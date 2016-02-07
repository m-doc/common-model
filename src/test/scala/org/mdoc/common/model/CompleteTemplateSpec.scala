package org.mdoc.common.model

import cats.data.Xor
import io.circe.generic.auto._
import io.circe.parse._
import io.circe.syntax._
import org.mdoc.common.model.circe._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import scodec.bits.ByteVector

object CompleteTemplateSpec extends Properties("CompleteTemplate") {

  {
    val json =
      """{"cfg":{"outputFormat":{"Pdf":{}},"backend":{"LibreOffice":{}}},"doc":{"format":{"Html":{}},"body":"SGVsbG8="}}"""
    val cfg = RenderingConfig(Pdf, LibreOffice)
    val doc = Document(Html, ByteVector("Hello".getBytes))
    val tmpl = CompleteTemplate(cfg, doc)

    property("JSON decode") = secure {
      decode[CompleteTemplate](json) ?= Xor.right(tmpl)
    }

    property("JSON encode") = secure {
      tmpl.asJson.noSpaces ?= json
    }
  }
}
