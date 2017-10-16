package com.madhouse.ssp

import java.io.{File, InputStreamReader}
import java.net.URI
import java.util.Properties

import com.madhouse.ssp.util.JDBCConf
import com.typesafe.config.{Config, ConfigFactory}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

import scala.collection.JavaConverters._

/**
  * Created by Sunxiang on 2017-07-27 09:12.
  */
class Configure(file: String) extends Serializable {

  val fs: FileSystem = FileSystem.get(new Configuration())

  implicit private val config: Config = {
    logger(s"config file: $file")
    val uri = new URI(file)
    uri.getScheme match {
      case "file" => ConfigFactory.parseFile(new File(uri)).getConfig("app")
      case "hdfs" => ConfigFactory.parseReader(new InputStreamReader(fs.open(new Path(uri), 10240))).getConfig("app")
      case _ => throw new IllegalArgumentException(s"unknown config: $file")
    }
  }

  private def getOrElse[T](path: String, default: T)(implicit config: Config) = {
    if (config.hasPath(path))
      default match {
        case _: String => config.getString(path).asInstanceOf[T]
        case _: Int => config.getInt(path).asInstanceOf[T]
        case _: Long => config.getLong(path).asInstanceOf[T]
        case _: Boolean => config.getBoolean(path).asInstanceOf[T]
        case _ => default
      }
    else default
  }

  val jdbcConf = {
    val conf = config.getConfig("mysql")
    val url = conf.getString("url")
    val prop = {
      val p = new Properties()
      p.put("user", getOrElse("user", "root")(conf))
      p.put("password", getOrElse("pwd", "123456")(conf))
      p
    }
    JDBCConf(url, prop)
  }

  val logPath = {
    val mediaBid = getOrElse("log.path.mediabid", "/madssp/bidlogs/mediabid")
    val dspBid = getOrElse("log.path.dspbid", "/madssp/bidlogs/dspbid")
    val impression = getOrElse("log.path.impression", "/madssp/bidlogs/impression")
    val click = getOrElse("log.path.click", "/madssp/bidlogs/click")
    new LogPath(mediaBid, dspBid, impression, click)
  }

  private val table = config.getConfig("table")
  val mediaBaseTable = getOrElse("media.base", "mad_report_media")(table)
  val mediaLocationTable = getOrElse("media.location", "mad_report_media_location")(table)
  val dspBaseTable = getOrElse("dsp.base", "mad_report_dsp")(table)
  val dspLocationTable = getOrElse("dsp.location", "mad_report_dsp_location")(table)
  val dspMediaTable = getOrElse("dsp.media", "mad_report_dsp_media")(table)
  val policyBaseTable = getOrElse("policy.base", "mad_report_policy")(table)
  val policyLocationTable = getOrElse("policy.location", "mad_report_policy_location")(table)
  val policyMediaTable = getOrElse("policy.media", "mad_report_policy_media")(table)

  val inserts = config.getStringList("insert").asScala.toList

  val startTask = getOrElse("task.start", "")
  val endTask= getOrElse("task.end", "")
}
