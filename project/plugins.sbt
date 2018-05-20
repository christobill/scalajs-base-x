// using scalajs
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.23")

// in order to use npm in the build process
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.12.0")

// adds the core kantan.sbt plugins
addSbtPlugin("com.nrinaudo" % "kantan.sbt" % "2.2.1")

// adds kantan support for scalajs
addSbtPlugin("com.nrinaudo" % "kantan.sbt-scalajs" % "2.2.1")

// adds kantan support for scalafmt
addSbtPlugin("com.nrinaudo" % "kantan.sbt-scalafmt" % "2.2.1")

// adds kantan support for scalastyle
addSbtPlugin("com.nrinaudo" % "kantan.sbt-scalastyle" % "2.2.1")

// in order to publish on sonatype/maven central
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.0")

// in order to publish on sonatype/maven central
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")
