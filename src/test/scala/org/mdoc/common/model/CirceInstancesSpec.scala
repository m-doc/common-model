package org.mdoc.common.model

import cats.data.Xor
import io.circe.{ Decoder, Encoder, Json }
import org.mdoc.common.model.CirceInstances._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import scodec.bits.ByteVector

object CirceInstancesSpec extends Properties("CirceInstances") {

  property("Decoder[ByteVector] success") = secure {
    Decoder[ByteVector].decodeJson(Json.string("SGVsbG8=")) ?=
      Xor.right(ByteVector("Hello".getBytes))
  }

  property("Decoder[ByteVector] failure") = secure {
    Decoder[ByteVector].decodeJson(Json.string("???")).isLeft
  }

  property("Encoder[ByteVector]") = secure {
    Encoder[ByteVector].apply(ByteVector("Hello".getBytes)) ?=
      Json.string("SGVsbG8=")
  }
}
