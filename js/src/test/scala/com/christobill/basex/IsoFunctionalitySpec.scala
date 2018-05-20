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
import scala.scalajs.js

class IsoFunctionalitySpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  describe("BaseX scala version and BaseX facade") {

    it("should give the same encoding result in base62") {
      forAll { (array0: js.Array[Char]) ⇒
        val array = array0.map(_.toInt)

        val basexJS    = new facades.BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
        val basexScala = new BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

        basexJS.encode(array) should equal(basexScala.encode(array.toArray))
      }
    }

    it("should give the same encoding result in base62 with leading zeros") {
      forAll { (array0: js.Array[Char]) ⇒
        val array = 0 +: array0.map(_.toInt)

        val basexJS    = new facades.BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
        val basexScala = new BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

        basexJS.encode(array) should equal(basexScala.encode(array.toArray))
      }
    }

    it("should give the same encoding result in base62 with 3 leading zeros") {
      forAll { (array0: js.Array[Char]) ⇒
        val array = 0 +: 0 +: 0 +: array0.map(_.toInt)

        val basexJS    = new facades.BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
        val basexScala = new BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

        basexJS.encode(array) should equal(basexScala.encode(array.toArray))
      }
    }

    it("should give the same encoding result in base62 with 3 leading zeros and 3 ending zero") {
      forAll { (array0: js.Array[Char]) ⇒
        val array = 0 +: 0 +: 0 +: array0.map(_.toInt) :+ 0 :+ 0 :+ 0

        val basexJS    = new facades.BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
        val basexScala = new BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

        basexJS.encode(array) should equal(basexScala.encode(array.toArray))
      }
    }

    it("should give the same encoding result in base58") {
      forAll { (array0: js.Array[Char]) ⇒
        val array = array0.map(_.toInt)

        val basexJS    = new facades.BaseX("123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz")
        val basexScala = new BaseX("123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz")

        basexJS.encode(array) should equal(basexScala.encode(array.toArray))
      }
    }

    it("should give the same encoding result in base64") {
      forAll { (array0: js.Array[Char]) ⇒
        val array = array0.map(_.toInt)

        val basexJS    = new facades.BaseX("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/")
        val basexScala = new BaseX("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/")

        basexJS.encode(array) should equal(basexScala.encode(array.toArray))
      }
    }

  }

}
