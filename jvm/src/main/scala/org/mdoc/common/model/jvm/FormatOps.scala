package org.mdoc.common.model.jvm

import org.http4s.MediaType
import org.http4s.MediaType._
import org.mdoc.common.model.Format
import org.mdoc.common.model.Format._

object FormatOps {

  def toMediaType(format: Format): MediaType =
    format match {
      case Bmp => `image/x-ms-bmp`
      case Docx => `application/vnd.openxmlformats-officedocument.wordprocessingml.document`
      case Html => `text/html`
      case Jpeg => `image/jpeg`
      case Latex => `application/x-tex`
      case Odt => `application/vnd.oasis.opendocument.text`
      case Pdf => `application/pdf`
      case Png => `image/png`
      case Ppm => MediaType.fromKey("image" -> "x-portable-pixmap")
      case Svg => `image/svg+xml`
      case Txt => `text/plain`
    }
}
