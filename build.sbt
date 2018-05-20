startYear in ThisBuild := Some(2018)

lazy val root = Project(id = "scalajs-base-x", base = file("."))
  .aggregate(basexJS, basexJVM)
  .settings(moduleName := "root")

skip in publish := true

/*
 * cross js/jvm project
 * shared code in ./shared
 * specific jvm code in ./jvm
 * specific js code in ./js
 */
lazy val basex = crossProject
  .in(file("."))
  .settings(
    name             := "scalajs-base-x",
    organization     := "com.christobill",
    organizationName := "christobill",
    // Dependencies that are provided both in scala and scalajs
    libraryDependencies ++= Seq(
      "org.scalatest"  %%% "scalatest"  % Versions.scalatest  % "test",
      "org.scalacheck" %%% "scalacheck" % Versions.scalacheck % "test"
    ),
// POM settings for Sonatype
    homepage := Some(url("https://github.com/christobill/scalajs-base-x")),
    scmInfo := Some(
      ScmInfo(url("https://github.com/christobill/scalajs-base-x"), "git@github.com:christobill/scalajs-base-x.git")
    ),
    developers := List(
      Developer("christobill", "Christophe Billiard", "root@christobill.com", url("https://github.com/christobill"))
    ),
    licenses          += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    publishMavenStyle := true,
// Add sonatype repository settings
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
  )
  .jvmSettings(
    // Add JVM-specific settings here
  )
  .jsSettings(
    // Add JS-specific settings here

    // Dependencies only provided scalajs
    libraryDependencies ++= Seq(),
    // This is an application with a main method
    scalaJSUseMainModuleInitializer := true,
    // Npm dependencies for AdSchemaValidator
    npmDependencies in Compile ++= Seq("base-x" → "3.0.4")
  )
  .enablePlugins(AutomateHeaderPlugin)

lazy val basexJVM = basex.jvm
lazy val basexJS  = basex.js.enablePlugins(ScalaJSBundlerPlugin)

enablePlugins(ScalaJSPlugin)
