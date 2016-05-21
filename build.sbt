name := """managerSystem"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  cache,
  javaWs,
  "mysql" % "mysql-connector-java" % "5.1.21",
  "joda-time" % "joda-time" % "2.8.1",
  "javax.xml.bind" % "jaxb-api" % "2.2.8"
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-q")
