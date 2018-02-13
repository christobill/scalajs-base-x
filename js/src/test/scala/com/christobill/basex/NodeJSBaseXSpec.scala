package com.christobill.basex

import scala.scalajs.js

class NodeJSBaseXSpec extends BaseXSpec {

  val basex = new facades.BaseX("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

  import js.JSConverters._

  def encode(array: Array[Int]): String = basex.encode(array.toJSArray)

  def decode(string: String): Array[Int] =
    basex.decode(string).asInstanceOf[js.Array[Int]].toArray
}
