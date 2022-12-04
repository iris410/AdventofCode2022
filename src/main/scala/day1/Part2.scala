package day1

import scala.io.Source

object Part2 extends App{
  //way 1
  /*var totalMax:Int = 0
  var preMax:Int = Int.MaxValue;
  for(i <- 1 to 3){
    val resource = Source.fromResource("day1-1.txt")
    val lines : Iterator[String] = resource.getLines
    var currentMax:Int = 0
    var caloriesPerPack:Int = 0
    while(lines.hasNext != false){
      var temp = lines.next()
      if(temp != "")
        caloriesPerPack = caloriesPerPack + temp.toInt
      else
          if(caloriesPerPack < preMax)
            currentMax = math.max(currentMax, caloriesPerPack)
          caloriesPerPack = 0
  }
    println(currentMax)
    totalMax = totalMax + currentMax
    preMax = currentMax;
  }
  println(totalMax)*/

  // way 2
  val resource = Source.fromResource("day1-1.txt")
  val lines : Iterator[String] = resource.getLines

  class TopThree(){
   val topThree = Array[Int](-1,-1,-1)//max at leftmost, min at rightmost
   def add(number:Int):Unit=
     if(number <=topThree(2))
       ()
     else if(number > topThree(2) && number <= topThree(1))
       topThree(2) = number
     else if(number > topThree(1) && number <= topThree(0))
       topThree(2) = topThree(1)
       topThree(1) = number
     else
       topThree(2) = topThree(1)
       topThree(1) = topThree(0)
       topThree(0) = number

   def total:Int=
    topThree.sum
  }

 val result = lines.foldLeft((TopThree(),0)){
    case ((topThree, pakegeCalories),"")  =>
      topThree.add(pakegeCalories)
      (topThree,0)
    case((topThree, pakegeCalories), line) => (topThree,pakegeCalories+line.toInt)
}._1.total

  println( result)
}