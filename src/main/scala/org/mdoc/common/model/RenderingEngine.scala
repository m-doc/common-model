package org.mdoc.common.model

import com.pellucid.sealerate

sealed abstract class RenderingEngine extends Product with Serializable

object RenderingEngine {
  case object LibreOffice extends RenderingEngine
  case object Pandoc extends RenderingEngine
  case object Wkhtmltoimage extends RenderingEngine
  case object Wkhtmltopdf extends RenderingEngine

  val values: Set[RenderingEngine] =
    sealerate.values[RenderingEngine]

  def fromString(str: String): Option[RenderingEngine] =
    nameToEngineMap.get(str.toLowerCase)

  private val nameToEngineMap: Map[String, RenderingEngine] =
    values.map(e => e.toString.toLowerCase -> e).toMap
}
