package cn.nk

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Words {
  def main(args: Array[String]): Unit = {
    val sparkConf:SparkConf = new SparkConf()
      .setAppName("words-app")
      .setMaster("local[2]")
    val sc: SparkContext = new SparkContext(sparkConf)
//    val arr:Array[(String, Int)]=sc.textFile("C:\\Users\\13219\\Desktop\\1.txt")
//      .flatMap(_.split(" "))
//      .map(x=>(x,1))
//      .reduceByKey(_+_)
//      .collect()
    val value:RDD[String] = sc.textFile("C:\\Users\\13219\\Desktop\\1.txt")
    val words:RDD[String] = value.flatMap(_.split(" "))
    val wordAndOne:RDD[(String,Int)] = words.map((_,1))
    val result:RDD[(String,Int)]=wordAndOne.reduceByKey(_+_)
    println(result.collect().toBuffer)

  }

}
