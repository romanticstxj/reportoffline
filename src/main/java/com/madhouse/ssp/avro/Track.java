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
public class Track extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -402988763814322294L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Track\",\"namespace\":\"com.madhouse.ssp.avro\",\"fields\":[{\"name\":\"startdelay\",\"type\":\"int\",\"default\":0},{\"name\":\"url\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Track> ENCODER =
      new BinaryMessageEncoder<Track>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Track> DECODER =
      new BinaryMessageDecoder<Track>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Track> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Track> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Track>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Track to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Track from a ByteBuffer. */
  public static Track fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public int startdelay;
  @Deprecated public java.lang.String url;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Track() {}

  /**
   * All-args constructor.
   * @param startdelay The new value for startdelay
   * @param url The new value for url
   */
  public Track(java.lang.Integer startdelay, java.lang.String url) {
    this.startdelay = startdelay;
    this.url = url;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return startdelay;
    case 1: return url;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: startdelay = (java.lang.Integer)value$; break;
    case 1: url = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'startdelay' field.
   * @return The value of the 'startdelay' field.
   */
  public java.lang.Integer getStartdelay() {
    return startdelay;
  }

  /**
   * Sets the value of the 'startdelay' field.
   * @param value the value to set.
   */
  public void setStartdelay(java.lang.Integer value) {
    this.startdelay = value;
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
   * Creates a new Track RecordBuilder.
   * @return A new Track RecordBuilder
   */
  public static com.madhouse.ssp.avro.Track.Builder newBuilder() {
    return new com.madhouse.ssp.avro.Track.Builder();
  }

  /**
   * Creates a new Track RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Track RecordBuilder
   */
  public static com.madhouse.ssp.avro.Track.Builder newBuilder(com.madhouse.ssp.avro.Track.Builder other) {
    return new com.madhouse.ssp.avro.Track.Builder(other);
  }

  /**
   * Creates a new Track RecordBuilder by copying an existing Track instance.
   * @param other The existing instance to copy.
   * @return A new Track RecordBuilder
   */
  public static com.madhouse.ssp.avro.Track.Builder newBuilder(com.madhouse.ssp.avro.Track other) {
    return new com.madhouse.ssp.avro.Track.Builder(other);
  }

  /**
   * RecordBuilder for Track instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Track>
    implements org.apache.avro.data.RecordBuilder<Track> {

    private int startdelay;
    private java.lang.String url;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.madhouse.ssp.avro.Track.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.startdelay)) {
        this.startdelay = data().deepCopy(fields()[0].schema(), other.startdelay);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.url)) {
        this.url = data().deepCopy(fields()[1].schema(), other.url);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Track instance
     * @param other The existing instance to copy.
     */
    private Builder(com.madhouse.ssp.avro.Track other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.startdelay)) {
        this.startdelay = data().deepCopy(fields()[0].schema(), other.startdelay);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.url)) {
        this.url = data().deepCopy(fields()[1].schema(), other.url);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'startdelay' field.
      * @return The value.
      */
    public java.lang.Integer getStartdelay() {
      return startdelay;
    }

    /**
      * Sets the value of the 'startdelay' field.
      * @param value The value of 'startdelay'.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Track.Builder setStartdelay(int value) {
      validate(fields()[0], value);
      this.startdelay = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'startdelay' field has been set.
      * @return True if the 'startdelay' field has been set, false otherwise.
      */
    public boolean hasStartdelay() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'startdelay' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Track.Builder clearStartdelay() {
      fieldSetFlags()[0] = false;
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
    public com.madhouse.ssp.avro.Track.Builder setUrl(java.lang.String value) {
      validate(fields()[1], value);
      this.url = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'url' field has been set.
      * @return True if the 'url' field has been set, false otherwise.
      */
    public boolean hasUrl() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'url' field.
      * @return This builder.
      */
    public com.madhouse.ssp.avro.Track.Builder clearUrl() {
      url = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Track build() {
      try {
        Track record = new Track();
        record.startdelay = fieldSetFlags()[0] ? this.startdelay : (java.lang.Integer) defaultValue(fields()[0]);
        record.url = fieldSetFlags()[1] ? this.url : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Track>
    WRITER$ = (org.apache.avro.io.DatumWriter<Track>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Track>
    READER$ = (org.apache.avro.io.DatumReader<Track>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}