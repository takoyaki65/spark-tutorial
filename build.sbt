import Dependencies._

ThisBuild / scalaVersion     := "2.12.18"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "spark-tutorial",
    libraryDependencies += munit % Test,
    libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.5",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.5"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
