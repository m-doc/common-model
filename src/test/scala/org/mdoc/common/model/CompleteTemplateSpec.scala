package org.mdoc.common.model

import cats.data.Xor
import io.circe.generic.auto._
import io.circe.parse._
import io.circe.syntax._
import org.mdoc.common.model.CirceInstances._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import scodec.bits.ByteVector

object CompleteTemplateSpec extends Properties("CompleteTemplate") {

  property("JSON decode") = secure {
    decode[CompleteTemplate]("""{"body":"SGVsbG8="}""") ?=
      Xor.right(CompleteTemplate(ByteVector("Hello".getBytes)))
  }

  property("JSON encode") = secure {
    CompleteTemplate(ByteVector("Hello".getBytes)).asJson.noSpaces ?=
      """{"body":"SGVsbG8="}"""
  }
}
