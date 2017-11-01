package com.madhouse.ssp

import java.time.LocalDate
import java.time.format.DateTimeFormatter.ofPattern

/**
  * Created by Sunxiang on 2017-08-09 14:05.
  *
  */
case class Task(day: String, hour: String) {
  val path = s"day=$day/hour=$hour"
  val date = LocalDate.parse(day, ofPattern("yyyyMMdd")).format(ofPattern("yyyy-MM-dd"))
  override def toString: String = s"Task{day: $day, hour: $hour}"
}

case class LogPath(mediaBid: String, dspBid: String, impression: String, click: String)