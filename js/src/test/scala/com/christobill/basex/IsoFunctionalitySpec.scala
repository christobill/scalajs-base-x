package com.christobill.basex

import com.christobill
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

import scala.scalajs.js

class IsoFunctionalitySpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  describe("com.test.facades.com.test.BaseX and basex.com.test.BaseX") {

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

    it("should give the same encoding result in base62 with 3 leading zeros and 1 ending zero") {
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
