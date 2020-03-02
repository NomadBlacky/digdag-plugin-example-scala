ThisBuild / scalaVersion := "2.13.1"
ThisBuild / organization := "dev.nomadblacky"
ThisBuild / organizationName := "NomadBlacky"
ThisBuild / resolvers ++= Seq(
  Resolver.bintrayRepo("digdag", "maven")
)

lazy val root = (project in file("."))
  .settings(
    name := "digdag-plugin-example-scala",
    libraryDependencies ++= Seq(
        "io.digdag"     % "digdag-spi"          % "0.9.41" % Provided,
        "io.digdag"     % "digdag-plugin-utils" % "0.9.41" % Provided,
        "org.scalatest" %% "scalatest"          % "3.0.8"  % Test
      )
  )
