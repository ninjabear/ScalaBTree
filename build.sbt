name := "ScalaBTree"

version := "1.0"

scalaVersion := "2.11.7"

// Read here for optional jars and dependencies
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.6.5" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")