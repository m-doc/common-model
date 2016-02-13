package org.mdoc.common.model

import org.http4s.MediaType
import org.http4s.MediaType._
import org.mdoc.common.model.Format._

sealed abstract class Format extends Product with Serializable {

  def toExtension: String =
    this match {
      case Docx => "docx"
      case Html => "html"
      case Jpeg => "jpg"
      case Latex => "tex"
      case Odt => "odt"
      case Pdf => "pdf"
      case Png => "png"
    }

  def toMediaType: MediaType =
    this match {
      case Docx => `application/vnd.openxmlformats-officedocument.wordprocessingml.document`
      case Html => `text/html`
      case Jpeg => `image/jpeg`
      case Latex => `application/x-tex`
      case Odt => `application/vnd.oasis.opendocument.text`
      case Pdf => `application/pdf`
      case Png => `image/png`
    }
}

object Format {
  case object Docx extends Format
  case object Html extends Format
  case object Jpeg extends Format
  case object Latex extends Format
  case object Odt extends Format
  case object Pdf extends Format
  case object Png extends Format
}
