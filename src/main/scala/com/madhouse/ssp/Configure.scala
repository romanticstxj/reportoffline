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
object Configure {

  var fs: FileSystem = _

  implicit var config: Config = _

  def initConf(hadoopEnv: String, conf: String) = {
    logger(s"hadoop env: $hadoopEnv, config path: $conf")

    fs = FileSystem.get {
      val conf = ConfigFactory.load("hadoop").getConfig(hadoopEnv)

      val configuration = new Configuration()
      conf.entrySet().iterator().asScala foreach { c =>
        val key = c.getKey
        configuration.set(c.getKey, conf.getString(key))
      }
      configuration
    }

    config = if (conf.startsWith("file://")) {
      ConfigFactory.parseFile(new File(new URI(conf))).getConfig("app")
    } else {
      val path = new Path(conf)
      ConfigFactory.parseReader(new InputStreamReader(fs.open(path, 10240))).getConfig("app")
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

  lazy val sparkMaster = getOrElse("spark.master", "local[*]")

  lazy val jdbcConf = {
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

  lazy val logPath = {
    val mediaBid = getOrElse("log.path.media_bid", "/madssp/bidlogs/media_bid")
    val dspBid = getOrElse("log.path.media_bid", "/madssp/bidlogs/dsp_bid")
    val impression = getOrElse("log.path.media_bid", "/madssp/bidlogs/impression")
    val click = getOrElse("log.path.media_bid", "/madssp/bidlogs/click")
    new LogPath(mediaBid, dspBid, impression, click)
  }

  private lazy val table = config.getConfig("table")
  lazy val mediaBaseTable = getOrElse("media.base", "mad_report_media")(table)
  lazy val mediaLocationTable = getOrElse("media.location", "mad_report_media_location")(table)
  lazy val dspBaseTable = getOrElse("dsp.base", "mad_report_dsp")(table)
  lazy val dspLocationTable = getOrElse("dsp.location", "mad_report_dsp_location")(table)
  lazy val dspMediaTable = getOrElse("dsp.media", "mad_report_dsp_media")(table)
  lazy val policyBaseTable = getOrElse("policy.base", "mad_report_policy")(table)
  lazy val policyLocationTable = getOrElse("policy.location", "mad_report_policy_location")(table)

  lazy val inserts = config.getStringList("insert").asScala.toList

  lazy val startTask = getOrElse("task.start", "")
  lazy val endTask= getOrElse("task.end", "")
}
