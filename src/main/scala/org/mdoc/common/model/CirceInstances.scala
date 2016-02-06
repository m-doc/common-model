package org.mdoc.common.model

import cats.data.Xor
import io.circe.{ Decoder, DecodingFailure, Encoder }
import scodec.bits.ByteVector

object CirceInstances {

  implicit val byteVectorDecoder: Decoder[ByteVector] =
    Decoder.instance { cursor =>
      Decoder[String].apply(cursor).flatMap { str =>
        ByteVector.fromBase64Descriptive(str) match {
          case Right(bytes) => Xor.right(bytes)
          case Left(err) => Xor.left(DecodingFailure(err, cursor.history))
        }
      }
    }

  implicit val byteVectorEncoder: Encoder[ByteVector] =
    Encoder[String].contramap(_.toBase64)
}
