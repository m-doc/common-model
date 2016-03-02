package org.mdoc.common.model

import org.scalacheck.Prop._
import org.scalacheck.Properties

object FormatSpec extends Properties("Format") {

  property("fromExtension . toExtension ~= id") = secure {
    Format.values.forall { format =>
      Format.fromExtension(format.toExtension).fold(false)(_ == format)
    }
  }
}
