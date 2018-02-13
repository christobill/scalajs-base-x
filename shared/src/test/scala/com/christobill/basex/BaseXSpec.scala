package com.christobill.basex

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

trait BaseXSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  def encode(array: Array[Int]): String

  def decode(string: String): Array[Int]

  describe("com.test.facades.com.test.BaseX") {

    it(s"should encode same in base62") {
      forAll { (array0: Array[Byte]) ⇒
        val array = array0.map(_.toInt + 128)

        decode(encode(array)) should equal(array)
      }

    }

    it(s"should encode csame in base62") {
      forAll { (string0: String) ⇒
        val string = "5Kd3NBUAdUnhyzenEwVLy9pBKxSwXvE9FMPyR4UKZvpe6E3AgLr"

        encode(decode(string)) should equal(string)
      }

    }
  }
}
