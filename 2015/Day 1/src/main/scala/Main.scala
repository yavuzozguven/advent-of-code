import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object Main {
  def main(args: Array[String]): Unit = {
    val path = Paths.get("input.txt")
    val str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)

    val value = str.foldLeft[Map[Char, Int]](Map.empty)((map, c) => map + (c -> (map.getOrElse(c, 0) + 1)))

    println(value.get('(').get-value.get(')').get)


    val i = str.foldLeft(""){(x,k) =>
      x
    }
    println(i)

    println(str.reduce((total,cur) => total+cur))

  }
}
