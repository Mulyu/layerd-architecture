lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.0"
)

lazy val basicSourceSettings = Seq(
  scalaSource in Compile := baseDirectory.value / "src" / "main",
  scalaSource in Test := baseDirectory.value / "src" / "test"
)

/**
  * projects
  */
lazy val root = project
  .in(file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "template"
  )
  .aggregate(
    application,
    domain,
    infra
  )

lazy val application = project
  .in(file("application"))
  .dependsOn(
    domain,
    infra
  )
  .settings(commonSettings ++ basicSourceSettings : _*)


lazy val domain = project
  .in(file("domain"))
  .dependsOn(
    infra
  )
  .settings(commonSettings ++ basicSourceSettings : _*)

lazy val infra = project
  .in(file("infra"))
  .settings(commonSettings ++ basicSourceSettings : _*)
