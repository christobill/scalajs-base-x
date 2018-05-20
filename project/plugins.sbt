// using scalajs
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.21")

// in order to use npm in the build process
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.9.0")

// adds the core kantan.sbt plugins
addSbtPlugin("com.nrinaudo" % "kantan.sbt" % "2.1.2")

// in order to publish on sonatype/maven central
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.0")

// in order to publish on sonatype/maven central
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.0")
