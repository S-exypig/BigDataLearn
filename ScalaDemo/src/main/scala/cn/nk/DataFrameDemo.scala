package cn.nk

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

import java.util.Properties


object DataFrameDemo {
  case class Person(id:Int,name:String,age:Int)

  def main(args: Array[String]): Unit ={
//    val spark = SparkSession.builder()
//      .appName("DataFrameDemo")
//      .master("local[2]")
//      .getOrCreate()
//    import spark.implicits._
//    spark.sparkContext.setLogLevel("WARN")

//    val frame: DataFrame = spark.read.text("dir/1.txt")
//    frame.printSchema() // value:string
//    frame.show()
//
//    val value: RDD[(Int, String, Int)] = spark.sparkContext.textFile("dir/1.txt")
//      .map(_.split(" ")).map(arr => (arr(0).toInt, arr(1), arr(2).toInt))
//
//    val frame1: DataFrame = value.toDF("ID", "name", "age")
//    frame1.printSchema()
//    frame1.show()
//
//    val frame2: DataFrame = spark.sparkContext.textFile("dir/1.txt")
//      .map(_.split(" "))
//      .map(arr => Person(arr(0).toInt, arr(1), arr(2).toInt)).toDF()
//    frame2.printSchema()
//    frame2.show()
//    val dataset1=spark.createDataset(spark.sparkContext.textFile("dir/1.txt"))
//    dataset1.show()
//    val dataset2=spark.read.text("dir/1.txt").as[String].toDF()
//    dataset2.show()
//    spark.sparkContext.stop()
//    spark.stop()

    val spark=SparkSession.builder()
      .appName("DataFrameMySQL")
      .master("local[2]")
      .getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    import spark.implicits._
    val url="jdbc:mysql://localhost:3306"
    val prop=new Properties()
    prop.setProperty("user","myuser")
    prop.setProperty("password","fy46939.-")
    spark.read.format("jdbc")
      .option("url","jdbc:mysql://localhost:3306/test")
      .option("driver","com.mysql.jdbc.Driver")
      .option("user","myuser")
      .option("password","fy46939.-")
      .option("dbtable","course")
      .load().show()

    spark.stop()
  }

}
