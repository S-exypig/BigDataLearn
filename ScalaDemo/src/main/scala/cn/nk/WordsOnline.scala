package cn.nk

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordsOnline {
  def main(args: Array[String]): Unit = {
    val sc=new SparkContext(new SparkConf().setAppName("WordsOnline"))
    val data:RDD[String]=sc.textFile(args(0))
    val result=data.flatMap(_.split(" ")).map(x=>(x,1)).reduceByKey(_+_)
    result.saveAsTextFile(args(1))
    sc.stop()
  }

}
