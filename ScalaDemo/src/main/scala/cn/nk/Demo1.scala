package cn.nk

object Demo1 {
  def main(args: Array[String]): Unit = {
    val list:List[Int] = List[Int](2, 4, 21, 4, 53, 0, 9, 8, -27)
    println(list.take(5))
    println(list.contains(0))
  }
}
