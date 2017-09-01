package com.madhouse.ssp

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

import scala.collection.mutable.Queue

object ReportApp {

  def main(args: Array[String]): Unit = {

    require(args.length == 1, s"config file is not set")

    implicit val configure = new Configure(args(0))
    import configure._

    val tasks = if (startTask.nonEmpty && endTask.nonEmpty) {
      val hours = startTask.until(endTask, ChronoUnit.HOURS)

      Queue.concat((0L to hours) map { i =>
        task(startTask.plusHours(i))
      })
    } else Queue(task(LocalDateTime.now(zone).minusHours(1)))

    new ReportService(tasks).run()
  }

}
