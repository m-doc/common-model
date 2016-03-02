package org.mdoc.common.model

import scodec.bits.ByteVector

final case class Document(format: Format, body: ByteVector)
