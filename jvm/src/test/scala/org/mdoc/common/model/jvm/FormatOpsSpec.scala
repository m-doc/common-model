package org.mdoc.common.model.jvm

import org.mdoc.common.model.Format
import org.scalacheck.Prop._
import org.scalacheck.Properties

object FormatOpsSpec extends Properties("FormatOps") {

  property("MediaTypes are non-empty") = secure {
    Format.values.forall { format =>
      FormatOps.toMediaType(format).renderString.nonEmpty
    }
  }
}
