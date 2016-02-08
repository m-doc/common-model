package org.mdoc.common.model

sealed abstract class RenderingEngine extends Product with Serializable

case object LibreOffice extends RenderingEngine
case object Wkhtmltoimage extends RenderingEngine
case object Wkhtmltopdf extends RenderingEngine
