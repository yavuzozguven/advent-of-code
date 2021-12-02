import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.collection.mutable

object Main {

  var hashMap = mutable.HashMap("forward"->0,"down"->0,"up"->0,"depth"->0)
  var str = ""

  def main(args: Array[String]): Unit = {
    val path = Paths.get("input.txt")
    str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)

    part1
    hashMap = mutable.HashMap("forward"->0,"down"->0,"up"->0,"depth"->0)
    part2
  }

  def part1: Unit = {
    str.split("\n").map{row =>
      val list = row.split(" ").toList
      hashMap(list(0)) = hashMap(list(0)) + list(1).trim.toInt
    }
    println((hashMap("down")-hashMap("up"))*hashMap("forward"))
  }

  def part2: Unit ={
    str.split("\n").map{row =>
      val list = row.split(" ").toList
      hashMap(list(0)) = hashMap(list(0)) + list(1).trim.toInt
      if(list(0).equals("forward")) {
        hashMap("depth") = hashMap("depth") + (hashMap("down") - hashMap("up"))*list(1).trim.toInt
      }
    }
    println(hashMap("forward").toLong*hashMap("depth").toLong)
  }
}
