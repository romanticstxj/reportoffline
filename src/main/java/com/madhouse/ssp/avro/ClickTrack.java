/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.madhouse.ssp.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ClickTrack extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2867418838705382187L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ClickTrack\",\"namespace\":\"com.madhouse.ssp.avro\",\"fields\":[{\"name\":\"time\",\"type\":\"long\"},{\"name\":\"ua\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"ip\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"status\",\"type\":\"int\"},{\"name\":\"impid\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mediaid\",\"type\":\"long\"},{\"name\":\"adspaceid\",\"type\":\"long\"},{\"name\":\"policyid\",\"type\":\"long\"},{\"name\":\"invalid\",\"type\":\"int\",\"default\":0},{\"name\":\"url\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"ext\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"dspid\",\"type\":\"long\"},{\"name\":\"income\",\"type\":\"int\"},{\"name\":\"cost\",\"type\":\"int\"},{\"name\":\"location\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ClickTrack> ENCODER =
      new BinaryMessageEncoder<ClickTrack>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ClickTrack> DECODER =
      new BinaryMessageDecoder<ClickTrack>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<ClickTrack> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<ClickTrack> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ClickTrack>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this ClickTrack to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a ClickTrack from a ByteBuffer. */
  public static ClickTrack fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long time;
  @Deprecated public java.lang.String ua;
  @Deprecated public java.lang.String ip;
  @Deprecated public int status;
  @Deprecated public java.lang.String impid;
  @Deprecated public long mediaid;
  @Deprecated public long adspaceid;
  @Deprecated public long policyid;
  @Deprecated public int invalid;
  @Deprecated public java.lang.String url;
  @Deprecated public java.lang.String ext;
  @Deprecated public long dspid;
  @Deprecated public int income;
  @Deprecated public int cost;
  @Deprecated public java.lang.String location;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ClickTrack() {}

  /**
   * All-args constructor.
   * @param time The new value for time
   * @param ua The new value for ua
   * @param ip The new value for ip
   * @param status The new value for status
   * @param impid The new value for impid
   * @param mediaid The new value for mediaid
   * @param adspaceid The new value for adspaceid
   * @param policyid The new value for policyid
   * @param invalid The new value for invalid
   * @param url The new value for url
   * @param ext The new value for ext
   * @param dspid The new value for dspid
   * @param income The new value for income
   * @param cost The new value for cost
   * @param location The new value for location
   */
  public ClickTrack(java.lang.Long time, java.lang.String ua, java.lang.String ip, java.lang.Integer status, java.lang.String impid, java.lang.Long mediaid, java.lang.Long adspaceid, java.lang.Long policyid, java.lang.Integer invalid, java.lang.String url, java.lang.String ext, java.lang.Long dspid, java.lang.Integer income, java.lang.Integer cost, java.lang.String location) {
    this.time = time;
    this.ua = ua;
    this.ip = ip;
    this.status = status;
    this.impid = impid;
    this.mediaid = mediaid;
    this.adspaceid = adspaceid;
    this.policyid = policyid;
    this.invalid = invalid;
    this.url = url;
    this.ext = ext;
    this.dspid = dspid;
    this.income = income;
    this.cost = cost;
    this.location = location;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return time;
    case 1: return ua;
    case 2: return ip;
    case 3: return status;
    case 4: return impid;
    case 5: return mediaid;
    case 6: return adspaceid;
    case 7: return policyid;
    case 8: return invalid;
    case 9: return url;
    case 10: return ext;
    case 11: return dspid;
    case 12: return income;
    case 13: return cost;
    case 14: return location;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: time = (java.lang.Long)value$; break;
    case 1: ua = (java.lang.String)value$; break;
    case 2: ip = (java.lang.String)value$; break;
    case 3: status = (java.lang.Integer)value$; break;
    case 4: impid = (java.lang.String)value$; break;
    case 5: mediaid = (java.lang.Long)value$; break;
    case 6: adspaceid = (java.lang.Long)value$; break;
    case 7: policyid = (java.lang.Long)value$; break;
    case 8: invalid = (java.lang.Integer)value$; break;
    case 9: url = (java.lang.String)value$; break;
    case 10: ext = (java.lang.String)value$; break;
    case 11: dspid = (java.lang.Long)value$; break;
    case 12: income = (java.lang.Integer)value$; break;
    case 13: cost = (java.lang.Integer)value$; break;
    case 14: location = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'time' field.
   * @return The value of the 'time' field.
   */
  public java.lang.Long getTime() {
    return time;
  }

  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(java.lang.Long value) {
    this.time = value;
  }

  /**
   * Gets the value of the 'ua' field.
   * @return The value of the 'ua' field.
   */
  public java.lang.String getUa() {
    return ua;
  }

  /**
   * Sets the value of the 'ua' field.
   * @param value the value to set.
   */
  public void setUa(java.lang.String value) {
    this.ua = value;
  }

  /**
   * Gets the value of the 'ip' field.
   * @return The value of the 'ip' field.
   */
  public java.lang.String getIp() {
    return ip;
  }

  /**
   * Sets the value of the 'ip' field.
   * @param value the value to set.
   */
  public void setIp(java.lang.String value) {
    this.ip = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.Integer getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.Integer value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'impid' field.
   * @return The value of the 'impid' field.
   */
  public java.lang.String getImpid() {
    return impid;
  }

  /**
   * Sets the value of the 'impid' field.
   * @param value the value to set.
   */
  public void setImpid(java.lang.String value) {
    this.impid = value;
  }

  /**
   * Gets the value of the 'mediaid' field.
   * @return The value of the 'mediaid' field.
   */
  public java.lang.Long getMediaid() {
    return mediaid;
  }

  /**
   * Sets the value of the 'mediaid' field.
   * @param value the value to set.
   */
  public void setMediaid(java.lang.Long value) {
    this.mediaid = value;
  }

  /**
   * Gets the value of the 'adspaceid' field.
   * @return The value of the 'adspaceid' field.
   */
  public java.lang.Long getAdspaceid() {
    return adspaceid;
  }

  /**
   * Sets the value of the 'adspaceid' field.
   * @param value the value to set.
   */
  public void setAdspaceid(java.lang.Long value) {
    this.adspaceid = value;
  }

  /**
   * Gets the value of the 'policyid' field.
   * @return The value of the 'policyid' field.
   */
  public java.lang.Long getPolicyid() {
    return policyid;
  }

  /**
   * Sets the value of the 'policyid' field.
   * @param value the value to set.
   */
  public void setPolicyid(java.lang.Long value) {
    this.policyid = value;
  }

  /**
   * Gets the value of the 'invalid' field.
   * @return The value of the 'invalid' field.
   */
  public java.lang.Integer getInvalid() {
    return invalid;
  }

  /**
   * Sets the value of the 'invalid' field.
   * @param value the value to set.
   */
  public void setInvalid(java.lang.Integer value) {
    this.invalid = value;
  }

  /**
   * Gets the value of the 'url' field.
   * @return The value of the 'url' field.
   */
  public java.lang.String getUrl() {
    return url;
  }

  /**
   * Sets the value of the 'url' field.
   * @param value the value to set.
   */
  public void setUrl(java.lang.String value) {
    this.url = value;
  }

  /**
   * Gets the value of the 'ext' field.
   * @return The value of the 'ext' field.
   */
  public java.lang.String getExt() {
    return ext;
  }

  /**
   * Sets the value of the 'ext' field.
   * @param value the value to set.
   */
  public void setExt(java.lang.String value) {
    this.ext = value;
  }

  /**
   * Gets the value of the 'dspid' field.
   * @return The value of the 'dspid' field.
   */
  public java.lang.Long getDspid() {
    return dspid;
  }

  /**
   * Sets the value of the 'dspid' field.
   * @param value the value to set.
   */
  public void setDspid(java.lang.Long value) {
    this.dspid = value;
  }

  /**
   * Gets the value of the 'income' field.
   * @return The value of the 'income' field.
   */
  public java.lang.Integer getIncome() {
    return income;
  }

  /**
   * Sets the value of the 'income' field.
   * @param value the value to set.
   */
  public void setIncome(java.lang.Integer value) {
    this.income = value;
  }

  /**
   * Gets the value of the 'cost' field.
   * @return The value of the 'cost' field.
   */
  public java.lang.Integer getCost() {
    return cost;
  }

  /**
   * Sets the value of the 'cost' field.
   * @param value the value to set.
   */
  public void setCost(java.lang.Integer value) {
    this.cost = value;
  }

  /**
   * Gets the value of the 'location' field.
   * @return The value of the 'location' field.
   */
  public java.lang.String getLocation() {
    return location;
  }

  /**
   * Sets the value of the 'location' field.
   * @param value the value to set.
   */
  public void setLocation(java.lang.String value) {
    this.location = value;
  }

  /**
   * Creates a new ClickTrack RecordBuilder.
   * @return A new ClickTrack RecordBuilder
   */
  public static com.madhouse.ssp.avro.ClickTrack.Builder newBuilder() {
    return new com.madhouse.ssp.avro.ClickTrack.Builder();
  }

  /**
   * Creates a new ClickTrack RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ClickTrack RecordBuilder
   */
  public static com.madhouse.ssp.avro.ClickTrack.Builder newBuilder(com.madhouse.ssp.avro.ClickTrack.Builder other) {
    return new com.madhouse.ssp.avro.ClickTrack.Builder(other);
  }

  /**
   * Creates a new ClickTrack RecordBuilder by copying an existing ClickTrack instance.
   * @param other The existing instance to copy.
   * @return A new ClickTrack RecordBuilder
   */
  public static com.madhouse.ssp.avro.ClickTrack.Builder newBuilder(com.madhouse.ssp.avro.ClickTrack other) {
    return new com.madhouse.ssp.avro.ClickTrack.Builder(other);
  }

  /**
   * RecordBuilder for ClickTrack instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ClickTrack>
    implements org.apache.avro.data.RecordBuilder<ClickTrack> {

    private long time;
    private java.lang.String ua;
    private java.lang.String ip;
    private int status;
    private java.lang.String impid;
    private long mediaid;
    private long adspaceid;
    private long policyid;
    private int invalid;
    private java.lang.String url;
    private java.lang.String ext;
    private long dspid;
    private int income;
    private int cost;
    private java.lang.String location;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.madhouse.ssp.avro.ClickTrack.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.time)) {
        this.time = data().deepCopy(fields()[0].schema(), other.time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.ua)) {
        this.ua = data().deepCopy(fields()[1].schema(), other.ua);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.ip)) {
        this.ip = data().deepCopy(fields()[2].schema(), other.ip);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.impid)) {
        this.impid = data().deepCopy(fields()[4].schema(), other.impid);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.mediaid)) {
        this.mediaid = data().deepCopy(fields()[5].schema(), other.mediaid);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.adspaceid)) {
        this.adspaceid = data().deepCopy(fields()[6].schema(), other.adspaceid);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.policyid)) {
        this.policyid = data().deepCopy(fields()[7].schema(), other.policyid);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.invalid)) {
        this.invalid = data().deepCopy(fields()[8].schema(), other.invalid);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.url)) {
        this.url = data().deepCopy(fields()[9].schema(), other.url);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.ext)) {
        this.ext = data().deepCopy(fields()[10].schema(), other.ext);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.dspid)) {
        this.dspid = data().deepCopy(fields()[11].schema(), other.dspid);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.income)) {
        this.income = data().deepCopy(fields()[12].schema(), other.income);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.cost)) {
        this.cost = data().deepCopy(fields()[13].schema(), other.cost);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.location)) {
        this.location = data().deepCopy(fields()[14].schema(), other.location);
        fieldSetFlags()[14] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing ClickTrack instance
     * @param other The existing instance to copy.
     */
    private Builder(com.madhouse.ssp.avro.ClickTrack other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.time)) {
        this.time = data().deepCopy(fields()[0].schema(), other.time);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.ua)) {
        this.ua = data().deepCopy(fields()[1].schema(), other.ua);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.ip)) {
        this.ip = data().deepCopy(fields()[2].schema(), other.ip);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.status)) {
        this.status = data().deepCopy(fields()[3].schema(), other.status);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.impid)) {
        this.impid = data().deepCopy(fields()[4].schema(), other.impid);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.mediaid)) {
        this.mediaid = data().deepCopy(fields()[5].schema(), other.mediaid);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.adspaceid)) {
        this.adspaceid = data().deepCopy(fields()[6].schema(), other.adspaceid);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.policyid)) {
        this.policyid = data().deepCopy(fields()[7].schema(), other.policyid);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.invalid)) {
        this.invalid = data().deepCopy(fields()[8].schema(), other.invalid);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.url)) {
        this.url = data().deepCopy(fields()[9].schema(), other.url);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.ext)) {
        this.ext = data().deepCopy(fields()[10].schema(), other.ext);
        fieldSetFlags()[10] = true;
      }
      if (isValidValue(fields()[11], other.dspid)) {
        this.dspid = data().deepCopy(fields()[11].schema(), other.dspid);
        fieldSetFlags()[11] = true;
      }
      if (isValidValue(fields()[12], other.income)) {
        this.income = data().deepCopy(fields()[12].schema(), other.income);
        fieldSetFlags()[12] = true;
      }
      if (isValidValue(fields()[13], other.cost)) {
        this.cost = data().deepCopy(fields()[13].schema(), other.cost);
        fieldSetFlags()[13] = true;
      }
      if (isValidValue(fields()[14], other.location)) {
        this.location = data().deepCopy(fields()[14].schema(), other.location);
        fieldSetFlags()[14] = true;
      }
    }

    /**
      * Gets the value of the 'time' field.
      * @return The value.
      */
    public java.lang.Long getTime() {
      return time;
    }

    /**
      * Sets the value of the 'time' field.
      * @param value The value of 'time'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setTime(long value) {
      validate(fields()[0], value);
      this.time = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'time' field has been set.
      * @return True if the 'time' field has been set, false otherwise.
      */
    public boolean hasTime() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'time' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearTime() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'ua' field.
      * @return The value.
      */
    public java.lang.String getUa() {
      return ua;
    }

    /**
      * Sets the value of the 'ua' field.
      * @param value The value of 'ua'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setUa(java.lang.String value) {
      validate(fields()[1], value);
      this.ua = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'ua' field has been set.
      * @return True if the 'ua' field has been set, false otherwise.
      */
    public boolean hasUa() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'ua' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearUa() {
      ua = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'ip' field.
      * @return The value.
      */
    public java.lang.String getIp() {
      return ip;
    }

    /**
      * Sets the value of the 'ip' field.
      * @param value The value of 'ip'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setIp(java.lang.String value) {
      validate(fields()[2], value);
      this.ip = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'ip' field has been set.
      * @return True if the 'ip' field has been set, false otherwise.
      */
    public boolean hasIp() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'ip' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearIp() {
      ip = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.Integer getStatus() {
      return status;
    }

    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setStatus(int value) {
      validate(fields()[3], value);
      this.status = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearStatus() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'impid' field.
      * @return The value.
      */
    public java.lang.String getImpid() {
      return impid;
    }

    /**
      * Sets the value of the 'impid' field.
      * @param value The value of 'impid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setImpid(java.lang.String value) {
      validate(fields()[4], value);
      this.impid = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'impid' field has been set.
      * @return True if the 'impid' field has been set, false otherwise.
      */
    public boolean hasImpid() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'impid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearImpid() {
      impid = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'mediaid' field.
      * @return The value.
      */
    public java.lang.Long getMediaid() {
      return mediaid;
    }

    /**
      * Sets the value of the 'mediaid' field.
      * @param value The value of 'mediaid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setMediaid(long value) {
      validate(fields()[5], value);
      this.mediaid = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'mediaid' field has been set.
      * @return True if the 'mediaid' field has been set, false otherwise.
      */
    public boolean hasMediaid() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'mediaid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearMediaid() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'adspaceid' field.
      * @return The value.
      */
    public java.lang.Long getAdspaceid() {
      return adspaceid;
    }

    /**
      * Sets the value of the 'adspaceid' field.
      * @param value The value of 'adspaceid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setAdspaceid(long value) {
      validate(fields()[6], value);
      this.adspaceid = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'adspaceid' field has been set.
      * @return True if the 'adspaceid' field has been set, false otherwise.
      */
    public boolean hasAdspaceid() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'adspaceid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearAdspaceid() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'policyid' field.
      * @return The value.
      */
    public java.lang.Long getPolicyid() {
      return policyid;
    }

    /**
      * Sets the value of the 'policyid' field.
      * @param value The value of 'policyid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setPolicyid(long value) {
      validate(fields()[7], value);
      this.policyid = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'policyid' field has been set.
      * @return True if the 'policyid' field has been set, false otherwise.
      */
    public boolean hasPolicyid() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'policyid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearPolicyid() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'invalid' field.
      * @return The value.
      */
    public java.lang.Integer getInvalid() {
      return invalid;
    }

    /**
      * Sets the value of the 'invalid' field.
      * @param value The value of 'invalid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setInvalid(int value) {
      validate(fields()[8], value);
      this.invalid = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'invalid' field has been set.
      * @return True if the 'invalid' field has been set, false otherwise.
      */
    public boolean hasInvalid() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'invalid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearInvalid() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'url' field.
      * @return The value.
      */
    public java.lang.String getUrl() {
      return url;
    }

    /**
      * Sets the value of the 'url' field.
      * @param value The value of 'url'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setUrl(java.lang.String value) {
      validate(fields()[9], value);
      this.url = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'url' field has been set.
      * @return True if the 'url' field has been set, false otherwise.
      */
    public boolean hasUrl() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'url' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearUrl() {
      url = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'ext' field.
      * @return The value.
      */
    public java.lang.String getExt() {
      return ext;
    }

    /**
      * Sets the value of the 'ext' field.
      * @param value The value of 'ext'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setExt(java.lang.String value) {
      validate(fields()[10], value);
      this.ext = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'ext' field has been set.
      * @return True if the 'ext' field has been set, false otherwise.
      */
    public boolean hasExt() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'ext' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearExt() {
      ext = null;
      fieldSetFlags()[10] = false;
      return this;
    }

    /**
      * Gets the value of the 'dspid' field.
      * @return The value.
      */
    public java.lang.Long getDspid() {
      return dspid;
    }

    /**
      * Sets the value of the 'dspid' field.
      * @param value The value of 'dspid'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setDspid(long value) {
      validate(fields()[11], value);
      this.dspid = value;
      fieldSetFlags()[11] = true;
      return this;
    }

    /**
      * Checks whether the 'dspid' field has been set.
      * @return True if the 'dspid' field has been set, false otherwise.
      */
    public boolean hasDspid() {
      return fieldSetFlags()[11];
    }


    /**
      * Clears the value of the 'dspid' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearDspid() {
      fieldSetFlags()[11] = false;
      return this;
    }

    /**
      * Gets the value of the 'income' field.
      * @return The value.
      */
    public java.lang.Integer getIncome() {
      return income;
    }

    /**
      * Sets the value of the 'income' field.
      * @param value The value of 'income'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setIncome(int value) {
      validate(fields()[12], value);
      this.income = value;
      fieldSetFlags()[12] = true;
      return this;
    }

    /**
      * Checks whether the 'income' field has been set.
      * @return True if the 'income' field has been set, false otherwise.
      */
    public boolean hasIncome() {
      return fieldSetFlags()[12];
    }


    /**
      * Clears the value of the 'income' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearIncome() {
      fieldSetFlags()[12] = false;
      return this;
    }

    /**
      * Gets the value of the 'cost' field.
      * @return The value.
      */
    public java.lang.Integer getCost() {
      return cost;
    }

    /**
      * Sets the value of the 'cost' field.
      * @param value The value of 'cost'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setCost(int value) {
      validate(fields()[13], value);
      this.cost = value;
      fieldSetFlags()[13] = true;
      return this;
    }

    /**
      * Checks whether the 'cost' field has been set.
      * @return True if the 'cost' field has been set, false otherwise.
      */
    public boolean hasCost() {
      return fieldSetFlags()[13];
    }


    /**
      * Clears the value of the 'cost' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearCost() {
      fieldSetFlags()[13] = false;
      return this;
    }

    /**
      * Gets the value of the 'location' field.
      * @return The value.
      */
    public java.lang.String getLocation() {
      return location;
    }

    /**
      * Sets the value of the 'location' field.
      * @param value The value of 'location'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder setLocation(java.lang.String value) {
      validate(fields()[14], value);
      this.location = value;
      fieldSetFlags()[14] = true;
      return this;
    }

    /**
      * Checks whether the 'location' field has been set.
      * @return True if the 'location' field has been set, false otherwise.
      */
    public boolean hasLocation() {
      return fieldSetFlags()[14];
    }


    /**
      * Clears the value of the 'location' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.ClickTrack.Builder clearLocation() {
      location = null;
      fieldSetFlags()[14] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ClickTrack build() {
      try {
        ClickTrack record = new ClickTrack();
        record.time = fieldSetFlags()[0] ? this.time : (java.lang.Long) defaultValue(fields()[0]);
        record.ua = fieldSetFlags()[1] ? this.ua : (java.lang.String) defaultValue(fields()[1]);
        record.ip = fieldSetFlags()[2] ? this.ip : (java.lang.String) defaultValue(fields()[2]);
        record.status = fieldSetFlags()[3] ? this.status : (java.lang.Integer) defaultValue(fields()[3]);
        record.impid = fieldSetFlags()[4] ? this.impid : (java.lang.String) defaultValue(fields()[4]);
        record.mediaid = fieldSetFlags()[5] ? this.mediaid : (java.lang.Long) defaultValue(fields()[5]);
        record.adspaceid = fieldSetFlags()[6] ? this.adspaceid : (java.lang.Long) defaultValue(fields()[6]);
        record.policyid = fieldSetFlags()[7] ? this.policyid : (java.lang.Long) defaultValue(fields()[7]);
        record.invalid = fieldSetFlags()[8] ? this.invalid : (java.lang.Integer) defaultValue(fields()[8]);
        record.url = fieldSetFlags()[9] ? this.url : (java.lang.String) defaultValue(fields()[9]);
        record.ext = fieldSetFlags()[10] ? this.ext : (java.lang.String) defaultValue(fields()[10]);
        record.dspid = fieldSetFlags()[11] ? this.dspid : (java.lang.Long) defaultValue(fields()[11]);
        record.income = fieldSetFlags()[12] ? this.income : (java.lang.Integer) defaultValue(fields()[12]);
        record.cost = fieldSetFlags()[13] ? this.cost : (java.lang.Integer) defaultValue(fields()[13]);
        record.location = fieldSetFlags()[14] ? this.location : (java.lang.String) defaultValue(fields()[14]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ClickTrack>
    WRITER$ = (org.apache.avro.io.DatumWriter<ClickTrack>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ClickTrack>
    READER$ = (org.apache.avro.io.DatumReader<ClickTrack>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
