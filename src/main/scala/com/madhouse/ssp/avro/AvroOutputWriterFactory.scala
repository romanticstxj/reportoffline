/*
 * Copyright 2014 Databricks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.madhouse.ssp.avro

import org.apache.hadoop.mapreduce.TaskAttemptContext

import org.apache.spark.sql.execution.datasources.{OutputWriter, OutputWriterFactory}
import org.apache.spark.sql.types.StructType

private[avro] class AvroOutputWriterFactory(
    schema: StructType,
    recordName: String,
    recordNamespace: String) extends OutputWriterFactory {

  def getFileExtension(context: TaskAttemptContext): String = {
    ".avro"
  }

  def newInstance(
      path: String,
      bucketId: Option[Int],
      dataSchema: StructType,
      context: TaskAttemptContext): OutputWriter = {
    newInstance(path, dataSchema, context)
  }

  def newInstance(
      path: String,
      dataSchema: StructType,
      context: TaskAttemptContext): OutputWriter = {
    new AvroOutputWriter(path, context, schema, recordName, recordNamespace)
  }
}