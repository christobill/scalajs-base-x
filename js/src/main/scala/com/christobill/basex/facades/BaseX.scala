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

package com.christobill.basex.facades

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("base-x", JSImport.Namespace)
class BaseX(base: String) extends js.Object {
  //Uint8Array
  def encode(array: js.Array[Int]): String = js.native

  def decodeUnsafe(input: String): js.Array[Int] = js.native

  def decode(input: String): js.Array[Int] = js.native

}
