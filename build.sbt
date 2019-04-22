name := "rdf"

version := "0.1"

scalaVersion := "2.11.11"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"
// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0"
// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.0" % "runtime"
// https://mvnrepository.com/artifact/org.apache.spark/spark-mllib-local
libraryDependencies += "org.apache.spark" %% "spark-mllib-local" % "2.4.0"
libraryDependencies ++= Seq("org.apache.spark" %% "spark-mllib" % "2.4.1", "org.apache.spark" %% "spark-mllib" % "2.4.1")
// https://mvnrepository.com/artifact/org.apache.kafka/kafka
libraryDependencies += "org.apache.kafka" %% "kafka" % "2.2.0"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.8"

// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.2.0"
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
libraryDependencies += "org.apache.kafka" % "kafka-streams" % "2.2.0"
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-log4j-appender
libraryDependencies += "org.apache.kafka" % "kafka-log4j-appender" % "2.2.0"
