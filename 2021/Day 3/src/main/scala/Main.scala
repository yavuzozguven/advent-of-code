import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.util.control.Breaks.{break, breakable}

object Main {
  var list : List[String] = null
  def main(args: Array[String]): Unit = {
    val path = Paths.get("input.txt")
    val str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)
    list = str.split("\n").toList


    part1
    part2

  }

  def part1: Unit = {
    val length = list(0).length
    var cnt = Array.fill(length-1)(0)
    list.foreach{r=>
      for(w <- 0 until length-1){
        if(r(w).equals('1'))
          cnt(w) += 1
        else
          cnt(w) -= 1
      }
    }
    var number = ""
    cnt.foreach{r=>
      if(r < 0)
        number += "0"
      else
        number += "1"
    }

    println(number)

    var number_reverse = ""
    number.foreach{r=>
      if(r.equals('1'))
        number_reverse += '0'
      else
        number_reverse += '1'
    }

    println(number_reverse)
  }

  def part2: Unit ={

    var list1 = list
    breakable{
      list1.zipWithIndex.foreach{ case (elem, i) =>

        var cnt = 0

        list1.foreach{r=>
          if(r(i).equals('1'))
            cnt += 1
          else
            cnt -= 1
        }

        if(cnt < 0){
          list1 = list1.filter(a => a(i).equals('0'))
        }
        if(cnt == 0 || cnt > 0)
          list1 = list1.filter(a => a(i).equals('1'))

        if(list1.length == 1)
          break()
      }
    }


    var list2 = list
    breakable{
      list2.zipWithIndex.foreach{ case (elem, i) =>

        var cnt = 0

        list2.foreach{r=>
          if(r(i).equals('1'))
            cnt += 1
          else
            cnt -= 1
        }

        if(cnt < 0){
          list2 = list2.filter(a => a(i).equals('1'))
        }
        if(cnt == 0 || cnt > 0)
          list2 = list2.filter(a => a(i).equals('0'))

        if(list2.length == 1)
          break()
      }
    }

    list1.foreach(println(_))
    list2.foreach(println(_))
  }
}
