package com.madhouse.ssp.entity


/**
  * Created by Sunxiang on 2017-08-02 15:03.
  *
  */
trait Record extends Serializable

case class MediaBidRecord(mediaId: Int, adSpaceId: Int, location: String, reqs: Long, bids: Long, errs: Long) extends Record

case class DspBidRecord(mediaId: Int, policyId: Int, dspId: Int, location: String, reqs: Long, bids: Long, wins: Long, timeouts: Long, errs: Long) extends Record

case class TrackerRecord(mediaId: Int, adSpaceId: Int, policyId: Int, dspId: Int, location: String, imps: Long, vimps: Long, clks: Long, vclks: Long, income: Long, cost: Long) extends Record

object MediaBidRecord {
  def apply(mediaId: Int, adSpaceId: Int, location: String, count: (Long, Long, Long)) = {
    new MediaBidRecord(mediaId, adSpaceId, location, count._1, count._2, count._3)
  }
}

object DspBidRecord {
  def apply(mediaId: Int, policyId: Int, dspId: Int, location: String, count: (Long, Long, Long, Long, Long)) = {
    new DspBidRecord(mediaId, policyId, dspId, location, count._1, count._2, count._3, count._4, count._5)
  }
}

object ImpressionRecord {
  def apply(mediaId: Int, adSpaceId: Int, policyId: Int, dspId: Int, location: String, countAndMoney: (Long, Long, Long, Long)) = {
    new TrackerRecord(mediaId, adSpaceId, policyId, dspId, location,  countAndMoney._1, 0L, countAndMoney._2, 0L, countAndMoney._3, countAndMoney._4)
  }
}

object ClickRecord {
  def apply(mediaId: Int, adSpaceId: Int, policyId: Int, dspId: Int, location: String, countAndMoney: (Long, Long, Long, Long)) = {
    new TrackerRecord(mediaId, adSpaceId, policyId, dspId, location, 0L, countAndMoney._1, 0L, countAndMoney._2, countAndMoney._3 * 1000, countAndMoney._4 * 1000)
  }
}