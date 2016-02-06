enablePlugins(MdocPlugin)

name := "common-model"

libraryDependencies ++= Seq(
  Library.circeCore,
  Library.circeGeneric,
  Library.circeParse,
  Library.scodecBits,
  Library.scalacheck % "test"
)
