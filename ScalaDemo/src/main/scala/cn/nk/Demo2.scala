package cn.nk

import scala.collection.mutable.ArrayBuffer

object Demo2 {
  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr2 = ArrayBuffer[Int](2, 4, 6, 8)
    println(arr1.mkString("Array(", ", ", ")"))
    println(arr2)
    println(arr2 += 10)
    arr2.insert(0,0)
    println(arr2)
    println(arr2 zip arr1)
    println(arr2(0))
    for(i <- arr1.indices) {
      println(arr1(i))
    }
  }
}
