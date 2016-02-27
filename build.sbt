enablePlugins(MdocPlugin)

name := "common-model"

resolvers += "pellucid/maven" at "http://dl.bintray.com/pellucid/maven"

libraryDependencies ++= Seq(
  Library.circeCore,
  Library.circeGeneric,
  Library.circeParse,
  Library.http4sCore,
  Library.scodecBits,
  Library.scalacheck % "test",
  "com.pellucid" %% "sealerate" % "0.0.3"
)
