package spark.TextProcessing

import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.feature.{StopWordsRemover, Tokenizer}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, SparkSession}

import scala.util.matching.Regex

object FeatureExtractor extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = SparkSession.builder().appName("FeatureExtractor").master("local[*]").getOrCreate()
  val myManualSchema = new StructType(Array(
    new StructField("Seq", IntegerType, true),
    new StructField("ClothingType", IntegerType, true),
    new StructField("Age", IntegerType, true),
    new StructField("Title", StringType, true),
    new StructField("ReviewText", StringType, true),
    new StructField("Rating", IntegerType, true),
    new StructField("RecommendedInD", IntegerType, true),
    new StructField("PositiveFeedbackCount", IntegerType, true),
    new StructField("DivisionName", StringType, true),
    new StructField("DepartmentName", StringType, true),
    new StructField("ClassName", StringType, true),
    new StructField("_corrupt_record", StringType, true)
  ))

  val file = spark.read
    .format("csv")
    .option("header", false)
    .option("sep", ",")
    .schema(myManualSchema)
    .option("mode", "permissive")
    .option("columnNameOfCorruptRecord", "_corrupt_record")
    .option("escape", "\"")
    .option("multiLine", true)
    .load("/home/shubhanshu/Downloads/Compressed/Womens Clothing E-Commerce Reviews.csv")

  import spark.implicits._

  val text = file.filter($"ClothingType".isNotNull && $"Title".isNotNull && $"ReviewText".isNotNull).select("ClothingType", "Title", "ReviewText")

  def RegexRep: (String => String) = {
    val pattern1 = new Regex("[!\"\\#$%&'()*+,\n\\-./:;<=>?@\\[\n\\\\\\]^_`{|}~\\[0-9\\]+]")
    val str1: CharSequence => String = pattern1.replaceAllIn(_, "")
    str1
  }

  val myUDF@org.apache.spark.sql.expressions.UserDefinedFunction(f, dataType, inputTypes): UserDefinedFunction = udf(RegexRep)

  import org.apache.spark.sql.functions.col

  val removedPunctuationDF: DataFrame = text.withColumn("CleanReviewText", myUDF(col("ReviewText")))
  removedPunctuationDF.show()

  val tokenizer: Tokenizer = new Tokenizer().setInputCol("CleanReviewText").setOutputCol("words")

  val t: DataFrame = tokenizer.transform(removedPunctuationDF)
  // t.show()

  val englishStopWords: Array[String] = StopWordsRemover.loadDefaultStopWords("english")
  val stops: StopWordsRemover = new StopWordsRemover()
    .setStopWords(englishStopWords)
    .setInputCol("words").setOutputCol("StopCol")
    .setInputCol("words").setOutputCol("StopCol")

  val stopDF = stops.transform(t)
  stopDF.show()
  // stopDF.write.format("txt").option("mode","OVERWRITE").save("/home/shubhanshu/Documents/stop.txt")
  println(stopDF.schema.fields.mkString(" "))


  //spark.stop()
}