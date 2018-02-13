// POM settings for Sonatype
homepage := Some(url("https://github.com/christobill/scalajs-base-x"))
scmInfo := Some(
  ScmInfo(url("https://github.com/christobill/scalajs-base-x"), "git@github.com:christobill/scalajs-base-x.git")
)
developers := List(
  Developer("christobill", "Christophe Billiard", "root@christobill.com", url("https://github.com/christobill"))
)
licenses          += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
publishMavenStyle := true

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
