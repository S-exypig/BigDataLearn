package cn.nk

object test02 {
  def main(args: Array[String]): Unit = {
    var site:List[String] =List("Runoob", "Google","Baidu")
    println(site.tail)

    var map: Map[String, String] = Map("红"->"red")
    map+=("黄"->"yellow")
    println(map)
    println(map.getOrElse("白","white"))
    map.values.foreach(println)
  }
}
