lazy val root = project.in(file("."))
  .enablePlugins(MdocPlugin)
  .aggregate(commonModelJVM, commonModelJS)
  .settings(noPublishSettings)

lazy val commonModel = crossProject.in(file("."))
  .enablePlugins(MdocPlugin)
  .settings(
    name := "common-model",
    libraryDependencies ++= Seq(
      Library.circeCore.js.value,
      Library.circeGeneric.js.value,
      Library.circeParse.js.value,
      Library.http4sCore,
      Library.sealerate,
      Library.scodecBits.js.value,
      Library.scalacheck.js.value % "test"
    )
  )
  .jsSettings(coverageExcludedPackages := ".*")

lazy val commonModelJVM = commonModel.jvm
lazy val commonModelJS = commonModel.js
