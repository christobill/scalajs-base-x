/*
 * Copyright 2018 christobill
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.christobill.basex

case class BaseX(base: String) {

  val aphabet0 = base.toList
  val aphabet  = base.toList.zipWithIndex.toMap

  val baseSize = base.size

  val leader = base.head

  def encode(source: Array[Int]): String =
    if (source.size == 0) ""
    else {
      var digits = Array(0)

      for (i ← 0 to source.size - 1) {
        var carry = source(i)
        for (j ← 0 to digits.size - 1) {

          carry = ((carry + (digits(j) << 8)))
          digits(j) = carry % baseSize

          carry = (carry / baseSize) | 0
        }

        while (carry > 0) {
          digits = digits :+ (carry % baseSize)

          carry = (carry / baseSize) | 0
        }

      }

      // deal with leading zeros
      val leading =
        source.take(source.size - 1).takeWhile(_ == 0).map(x ⇒ leader).mkString

      // convert digits to a string
      val result =
        (0 to digits.size - 1).reverse.map(x ⇒ aphabet0(digits(x))).mkString

      leading + result

    }
}
