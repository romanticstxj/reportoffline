package com.madhouse.ssp

import com.madhouse.ssp.Configure._
import com.madhouse.ssp.avro._
import com.madhouse.ssp.entity._
import org.apache.spark.sql.functions._
import org.apache.spark.sql._

import org.apache.avro.specific.SpecificRecordBase

import scala.collection.mutable.Queue

/**
  * Created by Sunxiang on 2017-08-08 16:18.
  *
  */
object ReportService {
  val spark = SparkSession.builder.appName(s"Report-OffLine").master(sparkMaster).getOrCreate()
  spark.sparkContext.hadoopConfiguration.addResource(fs.getConf)
  import spark.implicits._

  def read[T <: SpecificRecordBase](path: String, clazz: Class[T]) = {
    val data = spark.read.avro(path).as(Encoders.bean(clazz))
    clazz match {
      case ImpressionTrack | ClickTrack =>
        data.filter("invalid >= 0")
      case _ => data
    }
  }

  def write(data: DataFrame, table: String)(func: () => Unit) = {
    func()
    data.persist()
    data.show(10, false)
    data.write.jdbc(jdbcConf.url, table, jdbcConf.prop)
    data.unpersist()
  }

  val tracker: Dataset[TrackerRecord] => DataFrame = _
    .groupBy('mediaId as 'media_id, 'adSpaceId as 'adspace_id, 'policyId as 'policy_id, 'dspId as 'dsp_id, 'location)
    .agg(sum('imps) as 'imps, sum('clks) as 'clks, sum('vimps) as 'vimps, sum('vclks as 'vclks), sum('income) as 'income, sum('cost) as 'cost)
}

class ReportService(tasks: Queue[Task]) {
  import ReportService._
  import spark.implicits._

  def run() = while (!tasks.isEmpty) {
    runTask(tasks.dequeue)
  }

  def runTask(task: Task) = {
    logger(s"Running task $task ...")

    val mediaBid = read(s"${logPath.mediaBid}/${task.path}", classOf[MediaBid]) map { r =>
      MediaBidRecord(r.getRequest.getMediaid, r.getRequest.getAdspaceid, r.getLocation, mediaCount(r.getStatus))
    }

    val dspBid = read(s"${logPath.mediaBid}/${task.path}", classOf[DSPBid]) map { r =>
      DspBidRecord(r.getMediaid, r.getPolicyid, r.getDspid, r.getLocation, dspCount(r.getStatus, r.getWinner))
    }

    val impression = read(s"${logPath.mediaBid}/${task.path}", classOf[ImpressionTrack]) map { r =>
      ImpressionRecord(r.getMediaid, r.getAdspaceid, r.getPolicyid, r.getDspid, r.getLocation, impClkCount(r.getInvalid), r.getIncome, r.getCost)
    }

    val click = read(s"${logPath.mediaBid}/${task.path}", classOf[ClickTrack]) map { r =>
      ClickRecord(r.getMediaid, r.getAdspaceid, r.getPolicyid, r.getDspid, r.getLocation, impClkCount(r.getInvalid), r.getIncome, r.getCost)
    }

    def mediaData(df: DataFrame)(cols: Column*) = {
      df.groupBy(cols: _*)
        .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('errs) as 'errs, sum('imps) as 'imps, sum('clks) as 'clks, sum('vimps) as 'vimps, sum('vclks as 'vclks), sum('income) as 'income)
        .select(cols ++ Seq[Column](lit(task.day) as 'day, lit(task.hour.toInt) as 'hour, 'reqs, 'bids, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income): _*)
    }

    def dspData(df: DataFrame)(cols: Column*) = {
      df.groupBy(cols: _*)
        .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('wins) as 'wins, sum('timeouts) as 'timeouts, sum('errs) as 'errs, sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('cost) as 'cost)
        .select(cols ++ Seq[Column](lit(task.day) as 'day, lit(task.hour.toInt) as 'hour, 'reqs, 'bids, 'wins, 'timeouts, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'cost): _*)
    }

    def policyData(df: DataFrame)(cols: Column*) = {
      df.groupBy(cols: _*)
        .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('wins) as 'wins, sum('timeouts) as 'timeouts, sum('errs) as 'errs, sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('income) as 'income, sum('cost) as 'cost)
        .select(cols ++ Seq[Column](lit(task.day) as 'day, lit(task.hour.toInt) as 'hour, 'reqs, 'bids, 'wins, 'timeouts, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income, 'cost): _*)
    }

    if (inserts.nonEmpty) {
      val trackerData = tracker(impression union click).cache

      if (inserts.contains("media")) {
        val bidData = mediaBid
          .groupBy('mediaId, 'adSpaceId, 'location)
          .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('errs) as 'errs)

        val bidTrackerData = trackerData
          .groupBy('mediaId, 'adSpaceId, 'location)
          .agg(sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('income) as 'income)

        val baseData = bidData.as('m)
          .join(bidTrackerData.as('t), $"m.mediaId" === $"t.mediaId" and $"m.adSpaceId" === $"t.adSpaceId" and $"m.location" === $"t.location", "outer")
          .select(coalesce($"m.media_id", $"t.media_id") as 'media_id, coalesce($"m.adSpaceId", $"t.adSpaceId") as 'adspace_id, coalesce($"m.location", $"t.location") as 'location, 'reqs, 'bids, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income)
          .persist()

        write(mediaData(baseData)('media_id, 'adspace_id), mediaBaseTable) { () =>
          logger("media report data:")
        }

        write(baseData, mediaLocationTable) { () =>
          logger("media location report data:")
        }

        logger(s"save media data finished")
        baseData.unpersist()
      }

      if (inserts.contains("dsp") || inserts.contains("policy")) {
        val bidData = dspBid
          .groupBy('mediaId, 'policyId, 'dspId, 'location)
          .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('wins) as 'wins, sum('timeouts) as 'timeouts, sum('errs) as 'errs)

        val bidTrackerData = trackerData
          .groupBy('mediaId, 'policyId, 'dspId, 'location)
          .agg(sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('income) as 'income, sum('cost) as 'cost)

        val baseData = bidData.as('d)
          .join(bidTrackerData.as('t), $"d.mediaId" === $"t.mediaId" and $"d.policyId" === $"t.policyId" and $"d.dspId" === $"t.dspId" and $"d.location" === $"t.location", "outer")
          .select(coalesce($"m.media_id", $"t.media_id") as 'media_id, coalesce($"m.policyId", $"t.policyId") as 'policy_id, coalesce($"m.dspId", $"t.dspId") as 'dsp_id, coalesce($"m.location", $"t.location") as 'location, 'reqs, 'bids, 'wins, 'timeouts, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income, 'cost)
          .persist()

        if (inserts.contains("dsp")) {
          write(dspData(baseData)('dsp_id), dspBaseTable) { () =>
            logger("dsp report data:")
          }

          write(dspData(baseData)('dsp_id, 'location), dspLocationTable) { () =>
            logger("dsp location report data:")
          }

          write(dspData(baseData)('dsp_id, 'media), dspMediaTable) { () =>
            logger("dsp media report data:")
          }

          logger(s"save dsp data finished")
        }

        if (inserts.contains("policy")) {
          write(policyData(baseData)('policy_id, 'dsp_id), policyBaseTable) { () =>
            logger("policy report data:")
          }

          write(policyData(baseData)('policy_id, 'dsp_id, 'location), policyLocationTable) { () =>
            logger("policy location report data:")
          }

          logger(s"save policy data finished")
        }

        baseData.unpersist()
      }
    }
  }
}
