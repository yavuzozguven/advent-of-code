import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object Main {

  var list:List[Int] = null

  def main(args: Array[String]): Unit = {
    val path = Paths.get("input.txt")
    val str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)

    list = str.split("\n").map(a=>a.trim.toInt).toList

    part1
    part2
  }

  def part1(): Unit = {
    var i = 0
    var cnt = 0
    while(i<list.length-1){
      if(list(i)<list(i+1))
        cnt += 1
      i += 1
    }
    println(cnt)
  }

  def part2(): Unit = {
    var i = 0
    var cnt = 0
    while(i<list.length-3){
      val sum1 = list(i) + list(i+1) + list(i+2)
      val sum2 = list(i+1) + list(i+2) + list(i+3)
      if(sum2>sum1)
        cnt += 1
      i += 1
    }
    println(cnt)
  }
}
