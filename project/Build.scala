import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "sampleapp"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "com.github.twitter" %  "bootstrap"  % "2.0.2",
      "com.mongodb.casbah" %% "casbah"     % "2.1.5-1",
      "com.novus"          %% "salat-core" % "0.0.8-SNAPSHOT"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      resolvers ++= Seq(
        "webjars"          at "http://webjars.github.com/m2",
        "repo.novus snaps" at "http://repo.novus.com/snapshots/"
      )      
    )
}
