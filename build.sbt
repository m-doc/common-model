lazy val root = project.in(file("."))
  .enablePlugins(MdocPlugin)
  .aggregate(commonModelJVM, commonModelJS)
  .settings(
    publish := {},
    publishLocal := {},
    mdocValidateCommands --= Seq("coverage", "coverageReport")
  )

lazy val commonModel = crossProject.in(file("."))
  .enablePlugins(MdocPlugin)
  .settings(
    name := "common-model",
    resolvers += "pellucid/maven" at "http://dl.bintray.com/pellucid/maven",
    libraryDependencies ++= {
      import Library._
      Seq(
        circeCore.organization %%% circeCore.name % circeCore.revision,
        circeGeneric.organization %%% circeGeneric.name % circeGeneric.revision,
        circeParse.organization %%% circeParse.name % circeParse.revision,
        http4sCore,
        scodecBits.organization %%% scodecBits.name % scodecBits.revision,
        scalacheck.organization %%% scalacheck.name % scalacheck.revision % "test",
        "com.pellucid" %% "sealerate" % "0.0.3"
      )
    }
  )

lazy val commonModelJVM = commonModel.jvm
lazy val commonModelJS = commonModel.js
