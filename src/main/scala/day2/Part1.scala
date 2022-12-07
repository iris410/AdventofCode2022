package day2

import scala.io.Source

object Part1 extends App{
  val resource = Source.fromResource("day2-1.txt")
  val lines: Iterator[String] = resource.getLines
  val answer = lines.foldLeft(0)(
    (sum, line) =>
      sum + result(line(0), line(2)) + changeToInt(line(2))
  )
   println(answer)

  def result(abc: Char, xyz: Char): Int =
    if manipulateInput(abc) == xyz then 3
    else if changeToInt(manipulateInput(abc)) == changeToInt(xyz) + 1
      || changeToInt(manipulateInput(abc)) == changeToInt(xyz) - 2
      then 0
    else 6

  def changeToInt(s: Char): Int =
    s match {
      case 'X' => 1
      case 'Y' => 2
      case 'Z' => 3
    }

  def manipulateInput(s: Char): Char =
    s match {
      case 'A' => 'X'
      case 'B' => 'Y'
      case 'C' => 'Z'
    }
}
