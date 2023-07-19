package cn.nk

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

object DataFrameDemo {
  case class Person(id:Int,name:String,age:Int)

  def main(args: Array[String]): Unit ={
    val spark = SparkSession.builder()
      .appName("DataFrameDemo")
      .master("local[2]")
      .getOrCreate()

    spark.sparkContext.setLogLevel("WARN")

    val frame: DataFrame = spark.read.text("dir/1.txt")
    frame.printSchema() // value:string
    frame.show()

    val value: RDD[(Int, String, Int)] = spark.sparkContext.textFile("dir/1.txt")
      .map(_.split(" ")).map(arr => (arr(0).toInt, arr(1), arr(2).toInt))

    import spark.implicits._
    val frame1: DataFrame = value.toDF("ID", "name", "age")
    frame1.printSchema()
    frame1.show()

    val frame2: DataFrame = spark.sparkContext.textFile("dir/1.txt")
      .map(_.split(" "))
      .map(arr => Person(arr(0).toInt, arr(1), arr(2).toInt)).toDF()

    frame2.printSchema()
    frame2.show()

    spark.sparkContext.stop()
    spark.stop()
  }

}
