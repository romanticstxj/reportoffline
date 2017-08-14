package com.madhouse.ssp

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import scala.collection.mutable.Queue

object ReportApp {
  import Configure._

  def main(args: Array[String]): Unit = {
     val (hadoopEnv, configFile) = args.length match {
       case 1 => ("production", args(0))
       case 2 => (args(0), args(1))
       case _ => throw new IllegalArgumentException("the parameter length must equal 1 or 2")
     }

    require(Seq("develop", "beta", "production").contains(hadoopEnv), s"invalid hadoop environment $hadoopEnv")

    initConf(hadoopEnv, configFile)

    val tasks = if (startTask.nonEmpty && endTask.nonEmpty) {
      val hours = startTask.until(endTask, ChronoUnit.HOURS)

      Queue.concat((0L to hours) map { i =>
        task(startTask.plusHours(i))
      })
    } else Queue(task(LocalDateTime.now(zone).minusHours(1)))

    new ReportService(tasks).run()
  }

}
