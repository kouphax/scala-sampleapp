import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "sampleapp"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.github.twitter" %  "bootstrap"  % "2.0.2",
      "org.mongodb"         %% "casbah-core"     % "2.5.0-SNAPSHOT",
      "com.novus"          %% "salat-core" % "1.9.2-SNAPSHOT"
    )

  val main = play.Project(appName, appVersion, appDependencies).settings(

    resolvers ++= Seq(
      "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases",
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
      "webjars" at "http://webjars.github.com/m2"
    )
  )
}
