package org.mdoc.common.model

import com.pellucid.sealerate
import org.http4s.MediaType
import org.http4s.MediaType._
import org.mdoc.common.model.Format._

sealed abstract class Format extends Product with Serializable {

  def toExtension: String =
    this match {
      case Bmp => "bmp"
      case Docx => "docx"
      case Html => "html"
      case Jpeg => "jpg"
      case Latex => "tex"
      case Odt => "odt"
      case Pdf => "pdf"
      case Png => "png"
      case Svg => "svg"
      case Txt => "txt"
    }

  def toMediaType: MediaType =
    this match {
      case Bmp => `image/x-ms-bmp`
      case Docx => `application/vnd.openxmlformats-officedocument.wordprocessingml.document`
      case Html => `text/html`
      case Jpeg => `image/jpeg`
      case Latex => `application/x-tex`
      case Odt => `application/vnd.oasis.opendocument.text`
      case Pdf => `application/pdf`
      case Png => `image/png`
      case Svg => `image/svg+xml`
      case Txt => `text/plain`
    }
}

object Format {
  case object Bmp extends Format
  case object Docx extends Format
  case object Html extends Format
  case object Jpeg extends Format
  case object Latex extends Format
  case object Odt extends Format
  case object Pdf extends Format
  case object Png extends Format
  case object Svg extends Format
  case object Txt extends Format

  val values: Set[Format] =
    sealerate.values[Format]

  def fromExtension(ext: String): Option[Format] =
    extensionToFormatMap.get(ext.toLowerCase)

  private val extensionToFormatMap: Map[String, Format] =
    values.map(f => f.toExtension -> f).toMap
}
