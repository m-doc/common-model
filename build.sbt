enablePlugins(MdocPlugin)

name := "common-model"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % Version.scalacheck % "test"
)
