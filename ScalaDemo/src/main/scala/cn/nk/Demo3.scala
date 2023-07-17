package cn.nk

import scala.util.control.Breaks.{break, breakable}

object Demo3 {
  def main(args: Array[String]): Unit = {
    for (i <- Range(2, 1001)) {
      var flag: Boolean = false
      breakable(
        for (j <- Range(2, math.sqrt(i).toInt + 1)) {
          if (i % j == 0) {
            flag = true
            break
          }
        }
      )
      if (!flag)
        println(i)
    }
  }
}
