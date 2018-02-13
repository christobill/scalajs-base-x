package com.christobill.basex.facades

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("base-x", JSImport.Namespace)
class BaseX(base: js.Any) extends js.Object {
  //Uint8Array
  def encode(array: js.Array[Int]): String = js.native

  def decodeUnsafe(input: String): js.Any = js.native

  def decode(input: String): js.Any = js.native

}
