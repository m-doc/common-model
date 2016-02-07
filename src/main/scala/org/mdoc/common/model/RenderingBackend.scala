package org.mdoc.common.model

sealed abstract class RenderingBackend extends Product with Serializable

case object LibreOffice extends RenderingBackend
case object Wkhtmltoimage extends RenderingBackend
case object Wkhtmltopdf extends RenderingBackend
