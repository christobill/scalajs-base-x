package com.christobill.basex

case class BaseX(base: String) {

  val aphabet0 = base.toList
  val aphabet  = base.toList.zipWithIndex.toMap

  val BASE = base.size

  val LEADER = base.head

  def encode(source: Array[Int]): String =
    if (source.size == 0) ""
    else {
      var digits = Array(0)

      for (i ← 0 to source.size - 1) {
        var carry = source(i)
        for (j ← 0 to digits.size - 1) {

          carry = ((carry + (digits(j) << 8)))
          digits(j) = carry % BASE

          carry = (carry / BASE) | 0
        }

        while (carry > 0) {
          digits = digits :+ (carry % BASE)

          carry = (carry / BASE) | 0
        }

      }

      // deal with leading zeros
      val leading =
        source.take(source.size - 1).takeWhile(_ == 0).map(x ⇒ LEADER).mkString

      // convert digits to a string
      val result =
        (0 to digits.size - 1).reverse.map(x ⇒ aphabet0(digits(x))).mkString

      leading + result

    }
}
