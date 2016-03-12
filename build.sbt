lazy val root = project.in(file("."))
  .enablePlugins(MdocPlugin)
  .aggregate(commonModelJVM, commonModelJS)
  .settings(noPublishSettings)

lazy val commonModel = crossProject.in(file("."))
  .enablePlugins(MdocPlugin)
  .settings(
    name := "common-model",
    libraryDependencies ++= {
      import Library._
      Seq(
        circeCore.organization %%% circeCore.name % circeCore.revision,
        circeGeneric.organization %%% circeGeneric.name % circeGeneric.revision,
        circeParse.organization %%% circeParse.name % circeParse.revision,
        http4sCore,
        sealerate,
        scodecBits.organization %%% scodecBits.name % scodecBits.revision,
        scalacheck.organization %%% scalacheck.name % scalacheck.revision % "test"
      )
    }
  )
  .jsSettings(coverageExcludedPackages := ".*")

lazy val commonModelJVM = commonModel.jvm
lazy val commonModelJS = commonModel.js
