package org.mdoc.common.model

import io.circe.{ Decoder, Encoder, Json }
import org.mdoc.common.model.CirceInstances._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import scodec.bits.ByteVector

object CirceInstancesSpec extends Properties("CirceInstances") {

  property("Decoder[ByteVector]") = secure {
    Decoder[ByteVector].decodeJson(Json.string("SGVsbG8=")).getOrElse(ByteVector.empty) ?=
      ByteVector("Hello".getBytes)
  }

  property("Encoder[ByteVector]") = secure {
    Encoder[ByteVector].apply(ByteVector("Hello".getBytes)) ?= Json.string("SGVsbG8=")
  }
}
