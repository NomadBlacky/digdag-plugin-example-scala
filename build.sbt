ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "dev.nomadblacky"
ThisBuild / organizationName := "NomadBlacky"

lazy val root = (project in file("."))
  .settings(
    name := "digdag-plugin-example-scala",
    libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.0.8" % Test
      )
  )
