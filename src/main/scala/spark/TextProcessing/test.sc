val x = "love,me'</.no#!t"

import scala.util.matching.Regex


def RegexReplace(str: String): String = {
  val pattern = new Regex("\\p{Punct}")
  pattern.replaceAllIn(str, "~")
}


RegexReplace("fuck,all.me!into@shit.*")

val a = Array("love", "me", "ol")


val add = (a: Int, b: Int) => a + b

def ad(a: Int, b: Int) = a + b


