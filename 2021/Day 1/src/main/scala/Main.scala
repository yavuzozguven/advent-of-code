import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

object Main {
  def main(args: Array[String]): Unit = {
    val path = Paths.get("input.txt")
    val str = new String(Files.readAllBytes(path), StandardCharsets.UTF_8)

    val list = str.split("\n").map(a=>a.trim.toInt).toList

    var i = 0
    var cnt = 0
    while(i<list.length-1){
      if(list(i)<list(i+1))
        cnt += 1
      i += 1
    }

    println(cnt)

  }
}
