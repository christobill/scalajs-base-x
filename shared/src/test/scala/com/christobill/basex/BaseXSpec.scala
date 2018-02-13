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

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

trait BaseXSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  def codingLanguage: String

  def encode(array: Array[Int]): String

  def decode(string: String): Array[Int]

  describe(s"${codingLanguage} BaseX") {

    it("should verify decode ∘ encode = id") {
      forAll { (array0: Array[Byte]) ⇒
        val array = array0.map(_.toInt + 128)

        decode(encode(array)) should equal(array)
      }

    }

    it("should verify encode ∘ decode = id") {
      forAll { (string0: String) ⇒
        val string = "5Kd3NBUAdUnhyzenEwVLy9pBKxSwXvE9FMPyR4UKZvpe6E3AgLr"

        encode(decode(string)) should equal(string)
      }

    }
  }
}
