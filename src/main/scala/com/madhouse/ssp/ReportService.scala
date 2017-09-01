package com.madhouse.ssp

import com.databricks.spark.avro._
import com.madhouse.ssp.entity._
import com.madhouse.ssp.util.JDBCConf
import org.apache.spark.sql.functions._
import org.apache.spark.sql._
import org.apache.avro.specific.SpecificRecordBase

import scala.collection.mutable.Queue

/**
  * Created by Sunxiang on 2017-08-08 16:18.
  *
  */
object ReportService {
  val spark = SparkSession.builder
    .appName(s"Report-OffLine")
    .config("spark.debug.maxToStringFields", 128)
    .getOrCreate()

  def read[T <: SpecificRecordBase](path: String) = spark.read.avro(path)

  def write(data: DataFrame, table: String, jdbcConf: JDBCConf)(func: () => Unit) = {
    func()
    data.persist()
    data.show(10, false)
    data.write.mode(SaveMode.Append).jdbc(jdbcConf.url, table, jdbcConf.prop)
    data.unpersist()
  }
}

class ReportService(tasks: Queue[Task]) {
  import ReportService._
  import spark.implicits._

  def run()(implicit configure: Configure) = while (!tasks.isEmpty) {
    runTask(tasks.dequeue)
  }

  def runTask(task: Task)(implicit configure: Configure) = {
    logger(s"Running task $task ...")

    import configure._

    val mediaBid = read(s"${logPath.mediaBid}/${task.path}") map { r =>
      val request = r.getStruct(8)
      MediaBidRecord(request.getLong(1).toInt, request.getLong(6).toInt, r.getString(7), mediaCount(r.getInt(4)))
    }

    val dspBid = read(s"${logPath.dspBid}/${task.path}") map { r =>
      DspBidRecord(r.getLong(4).toInt, r.getLong(2).toInt, r.getLong(1).toInt, r.getString(6), dspCount(r.getInt(7), r.getInt(9)))
    }

    val impression = read(s"${logPath.impression}/${task.path}") filter { _.getInt(9) > 0 } map { r =>
      ImpressionRecord(r.getLong(5).toInt, r.getLong(6).toInt, r.getLong(7).toInt, r.getLong(11).toInt, r.getString(14), impClkCount(r.getInt(9)), r.getInt(12), r.getInt(13))
    }

    val click = read(s"${logPath.click}/${task.path}") filter { _.getInt(9) > 0 } map { r =>
      ClickRecord(r.getLong(5).toInt, r.getLong(6).toInt, r.getLong(7).toInt, r.getLong(12).toInt, r.getString(15), impClkCount(r.getInt(9)), r.getInt(13), r.getInt(14))
    }

    def mediaData(df: DataFrame)(cols: Column*) = {
      df.groupBy(cols: _*)
        .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('errs) as 'errs, sum('imps) as 'imps, sum('clks) as 'clks, sum('vimps) as 'vimps, sum('vclks) as 'vclks, sum('income) as 'income)
        .select(cols ++ Seq[Column]('reqs, 'bids, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income): _*)
    }

    def dspData(df: DataFrame)(cols: Column*) = {
      df.groupBy(cols: _*)
        .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('wins) as 'wins, sum('timeouts) as 'timeouts, sum('errs) as 'errs, sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('cost) as 'cost)
        .select(cols ++ Seq[Column]('reqs, 'bids, 'wins, 'timeouts, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'cost): _*)
    }

    def policyData(df: DataFrame)(cols: Column*) = {
      df.groupBy(cols: _*)
        .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('wins) as 'wins, sum('timeouts) as 'timeouts, sum('errs) as 'errs, sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('income) as 'income, sum('cost) as 'cost)
        .select(cols ++ Seq[Column]('reqs, 'bids, 'wins, 'timeouts, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income, 'cost): _*)
    }

    if (inserts.nonEmpty) {
      val trackerBaseData = (impression union click)
        .groupBy('mediaId, 'adSpaceId, 'policyId, 'dspId, 'location)
        .agg(sum('imps) as 'imps, sum('clks) as 'clks, sum('vimps) as 'vimps, sum('vclks) as 'vclks, sum('income) as 'income, sum('cost) as 'cost).persist()

      if (inserts.contains("media")) {
        val mediaBidData = mediaBid
          .groupBy('mediaId, 'adSpaceId, 'location)
          .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('errs) as 'errs)

        val trackerData = trackerBaseData
          .groupBy('mediaId, 'adSpaceId, 'location)
          .agg(sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('income) as 'income)

        val baseData = mediaBidData.as('m)
          .join(trackerData.as('t), $"m.mediaId" === $"t.mediaId" and $"m.adSpaceId" === $"t.adSpaceId" and $"m.location" === $"t.location", "outer")
          .select(coalesce($"m.mediaId", $"t.mediaId") as 'media_id, coalesce($"m.adSpaceId", $"t.adSpaceId") as 'adspace_id, coalesce($"m.location", $"t.location") as 'location, lit(task.day) as 'date, lit(task.hour.toInt) as 'hour, 'reqs, 'bids, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income)
          .na.fill(0L, Seq("bids", "errs", "imps", "clks", "vimps", "vclks", "income"))
          .persist()

        write(mediaData(baseData)('media_id, 'adspace_id, 'date, 'hour), mediaBaseTable, jdbcConf) { () =>
          logger("media report data:")
        }

        write(baseData, mediaLocationTable, jdbcConf) { () =>
          logger("media location report data:")
        }

        logger(s"save media data finished\n")
        baseData.unpersist()
      }

      if (inserts.contains("dsp") || inserts.contains("policy")) {
        val dspBidData = dspBid
          .groupBy('mediaId, 'policyId, 'dspId, 'location)
          .agg(sum('reqs) as 'reqs, sum('bids) as 'bids, sum('wins) as 'wins, sum('timeouts) as 'timeouts, sum('errs) as 'errs)

        val trackerData = trackerBaseData
          .groupBy('mediaId, 'policyId, 'dspId, 'location)
          .agg(sum('imps) as 'imps, sum('vimps) as 'vimps, sum('clks) as 'clks, sum('vclks) as 'vclks, sum('income) as 'income, sum('cost) as 'cost)

        val baseData = dspBidData.as('d)
          .join(trackerData.as('t), $"d.mediaId" === $"t.mediaId" and $"d.policyId" === $"t.policyId" and $"d.dspId" === $"t.dspId" and $"d.location" === $"t.location", "outer")
          .select(coalesce($"d.mediaId", $"t.mediaId") as 'media_id, coalesce($"d.policyId", $"t.policyId") as 'policy_id, coalesce($"d.dspId", $"t.dspId") as 'dsp_id, coalesce($"d.location", $"t.location") as 'location, lit(task.day) as 'date, lit(task.hour.toInt) as 'hour, 'reqs, 'bids, 'wins, 'timeouts, 'errs, 'imps, 'clks, 'vimps, 'vclks, 'income, 'cost)
          .na.fill(0L, Seq("reqs", "bids", "wins", "timeouts", "errs", "imps", "clks", "vimps", "vclks", "income", "cost"))
          .persist()

        if (inserts.contains("dsp")) {
          write(dspData(baseData)('dsp_id, 'date, 'hour), dspBaseTable, jdbcConf) { () =>
            logger("dsp report data:")
          }

          write(dspData(baseData)('dsp_id, 'location, 'date, 'hour), dspLocationTable, jdbcConf) { () =>
            logger("dsp location report data:")
          }

          write(dspData(baseData)('dsp_id, 'media_id, 'date, 'hour), dspMediaTable, jdbcConf) { () =>
            logger("dsp media report data:")
          }

          logger(s"save dsp data finished\n")
        }

        if (inserts.contains("policy")) {
          write(policyData(baseData)('policy_id, 'dsp_id, 'date, 'hour), policyBaseTable, jdbcConf) { () =>
            logger("policy report data:")
          }

          write(policyData(baseData)('policy_id, 'dsp_id, 'location, 'date, 'hour), policyLocationTable, jdbcConf) { () =>
            logger("policy location report data:")
          }

          logger(s"save policy data finished\n")
        }

        baseData.unpersist()
      }
    }
  }
}
