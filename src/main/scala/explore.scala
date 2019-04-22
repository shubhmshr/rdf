import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature.StringIndexer

object explore extends App {


  val spark = SparkSession.builder().master("local[*]").appName("StringIndexer").getOrCreate()
  Logger.getLogger("org").setLevel(Level.ERROR)

  import spark.implicits._

  val cov = spark.read.format("csv")
    .option("inferSchema", true)
    .option("header", true).option("sep", ",")
    .load("/media/shubhanshu/New Volume/Books/big data/Apache Spark/code files/Learning-Spark-SQL-master/data/dataset_diabetes/diabetic_data.csv")
  //cov.show(10)

  val raceIndexer = new StringIndexer()
    .setInputCol("race")
    .setOutputCol("raceIndexer")
    .fit(cov)

  raceIndexer.transform(cov).select($"race", $"raceIndexer").distinct().show(10)
}
