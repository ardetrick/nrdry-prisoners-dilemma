name := "prisoners-dilemma"

organization := "Nerdery"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test"
)

assemblyJarName in assembly := "prisoners-dilemma.jar"
