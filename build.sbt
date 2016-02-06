enablePlugins(MdocPlugin)

name := "common-model"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.2.0",
  Library.scodecBits,
  Library.scalacheck % "test"
)
