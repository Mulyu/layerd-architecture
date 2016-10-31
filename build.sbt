lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.0"
)

/**
  * projects
  */
lazy val root = project
  .in(new File("."))
  .settings(commonSettings: _*)
  .settings(
    name := "template"
  )
