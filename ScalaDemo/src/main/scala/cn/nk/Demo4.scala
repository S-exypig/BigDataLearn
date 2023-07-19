package cn.nk

import org.apache.spark.{SparkConf, SparkContext}

object Demo4 {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local[2]").setAppName("demo4"))
    sc.setLogLevel("warn")
    val data = sc.textFile("D:\\学习文档\\大数据实训\\words.txt")
    val value = data.filter(_.contains("halo"))
    println(data.collect().toBuffer)
    println(value.collect().toBuffer)
    val value2 = data.map(_.split(" "))
    value2.foreach(arr=>println(arr.mkString(" ")))
  }

}
