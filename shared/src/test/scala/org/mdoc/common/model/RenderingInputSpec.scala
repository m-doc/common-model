package org.mdoc.common.model

import cats.data.Xor
import io.circe.generic.auto._
import io.circe.parse._
import io.circe.syntax._
import org.mdoc.common.model.Format.{ Html, Pdf }
import org.mdoc.common.model.RenderingEngine.LibreOffice
import org.mdoc.common.model.circe._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import scodec.bits.ByteVector

object RenderingInputSpec extends Properties("RenderingInput") {

  {
    val json = """
      {"id":{"self":"42"},"config":{"outputFormat":{"Pdf":{}},"engine":{"LibreOffice":{}}},"doc":{"format":{"Html":{}},"body":"SGVsbG8sIFdvcmxkIQ=="}}
    """.trim

    val config = RenderingConfig(Pdf, LibreOffice)
    val doc = Document(Html, ByteVector("Hello, World!".getBytes))
    val input = RenderingInput(JobId("42"), config, doc)

    property("JSON decode") = secure {
      decode[RenderingInput](json) ?= Xor.right(input)
    }

    property("JSON encode") = secure {
      input.asJson.noSpaces ?= json
    }
  }
}
