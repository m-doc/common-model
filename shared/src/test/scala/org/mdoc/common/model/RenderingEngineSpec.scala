package org.mdoc.common.model

import org.scalacheck.Prop._
import org.scalacheck.Properties

object RenderingEngineSpec extends Properties("RenderingEngine") {

  property("fromString . toString ~= id") = secure {
    RenderingEngine.values.forall { engine =>
      RenderingEngine.fromString(engine.toString).fold(false)(_ == engine)
    }
  }
}
