package org.mdoc.common.model

sealed abstract class Format extends Product with Serializable

object Format {
  case object Docx extends Format
  case object Html extends Format
  case object Jpeg extends Format
  case object Latex extends Format
  case object Odt extends Format
  case object Pdf extends Format
  case object Png extends Format
}
