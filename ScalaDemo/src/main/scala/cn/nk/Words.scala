package cn.nk

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


object Words {
  def main(args: Array[String]): Unit = {
    val sparkConf:SparkConf = new SparkConf()
      .setAppName("words-app")
      .setMaster("local[2]")
    val sc: SparkContext = new SparkContext(sparkConf)
//    val arr:Array[(String, Int)]=sc.textFile("D:\\学习文档\\大数据实训\\words.txt")
//      .flatMap(_.split(" "))
//      .map(x=>(x,1))
//      .reduceByKey(_+_)
//      .collect()
    val value:RDD[String] = sc.textFile("D:\\学习文档\\大数据实训\\words.txt")
    val words:RDD[String] = value.flatMap(_.split(" "))
    val wordAndOne:RDD[(String,Int)] = words.map((_,1))
    val result:RDD[(String,Int)]=wordAndOne.reduceByKey(_+_)
    println(result.collect().toBuffer)

  }

}
