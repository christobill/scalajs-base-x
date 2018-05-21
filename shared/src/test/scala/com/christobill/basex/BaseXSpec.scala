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
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.collection.NonEmpty
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._
import org.scalacheck.Arbitrary
import shapeless.Witness

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

    val base      = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val a: String = s"[$base]*"
    val x         = Witness(a)
    type Test0 = String Refined MatchesRegex[x.T]
    val i1: Either[String, Test0] = refineV("ab")

    import org.scalacheck.Gen

    implicit lazy val arbDouble: Arbitrary[Test0] = Arbitrary(
      (for {
        e ← Gen.listOf(Gen.oneOf(base.toCharArray))
      } yield e.mkString)
        .map[Either[String, Test0]](x ⇒ refineV(x))
        .filter(x ⇒ x.isRight)
        .map(_.right.get) //.filter(x: Either[String, Test0] => x.isRight)
    )

    import eu.timepit.refined.scalacheck.string._

    it("should verify encode ∘ decode = id") {
      forAll { (string0: Test0) ⇒
        val string = string0

        encode(decode(string.value)) should equal(string.value)
      }

    }
  }
}
