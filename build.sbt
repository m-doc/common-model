enablePlugins(MdocPlugin)

name := "common-model"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.2.0",
  "io.circe" %% "circe-parse" % "0.2.0",
  Library.circeGeneric,
  Library.scodecBits,
  Library.scalacheck % "test"
)
