enablePlugins(MdocPlugin)

name := "common-model"

libraryDependencies ++= Seq(
  Library.circeCore,
  Library.circeGeneric,
  Library.circeParse,
  Library.http4sCore,
  Library.scodecBits,
  Library.scalacheck % "test"
)
