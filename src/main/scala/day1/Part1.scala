package day1
import scala.io.Source


object Part1 extends App{
  val resource = Source.fromResource("day1-1.txt")
  val lines : Iterator[String] = resource.getLines
  //way 1
/*  var max:Int = 0
  var weight:Int = 0
  while(lines.hasNext != false){
    var temp = lines.next()
    if(temp != "")
      weight = weight + temp.toInt
    else
      max = Math.max(max, weight)
      weight = 0
  }
  println(max)*/
  //way 2
  val maxResult = lines.foldLeft((0,0)){
  case ((aggr, max), "") => (0, math.max(aggr, max))
  case ((aggr, max), line) => (aggr + line.toInt, max)
  }._2
  println(maxResult)
}
