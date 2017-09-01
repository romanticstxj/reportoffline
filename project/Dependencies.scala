import sbt._

object Dependencies {
  // Versions
  val sparkVersion = "2.2.0"
  val avroVersion  = "1.8.2"

  // Libraries
  val config     = "com.typesafe"       % "config"                    % "1.3.1"
  val sparkSQL   = "org.apache.spark"  %% "spark-sql"                 % sparkVersion   /*% Provided*/  exclude("org.apache.hadoop", "hadoop-client")
  val avro       = "org.apache.avro"    % "avro"                      % avroVersion
  val sparkAvro  = "com.databricks"    %% "spark-avro"                % "3.2.0"
  val hadoopC    = "org.apache.hadoop"  % "hadoop-client"             % "2.7.3"        /*% Provided*/
  val mysqlConn  = "mysql"              % "mysql-connector-java"      % "5.1.43"       /*% Provided*/

  // Projects
  val rootDeps = Seq(config, sparkSQL, avro, sparkAvro, hadoopC, mysqlConn)

  // Resolvers
  val rootResolvers = Seq()
}