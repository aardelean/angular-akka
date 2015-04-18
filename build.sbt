import com.earldouglas.xwp.XwpPlugin._
import spray.revolver.RevolverPlugin.Revolver

name := "angular-akka"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

sbtVersion := "0.13.7"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "play repository" at "http://repo.typesafe.com/typesafe/releases/"

val akkaV = "2.3.9"

val sprayV = "1.3.3"

val stage = settingKey[String]("stage")

stage := sys.props.getOrElse("stage", default = "dev")

libraryDependencies ++= Seq(
  "io.spray"            %%  "spray-servlet" % sprayV,
  "io.spray"            %%  "spray-routing" % sprayV,
  "io.spray"            %%  "spray-testkit" % sprayV  % "test",
  "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
  "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
  "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
  "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container, compile",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
  "net.fwbrasil" %% "activate-core" % "1.7",
  "net.fwbrasil" %% "activate-jdbc" % "1.7",
  "org.mockito" % "mockito-core" % "1.10.17" % "test",
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "com.novocode" % "junit-interface" % "0.9" % "test",
  "mysql" % "mysql-connector-java" % "5.1.27"
)

javaOptions ++= Seq(
  "-Xdebug",
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9001"
)

jetty()

unmanagedResourceDirectories in Compile ++= Seq(file(baseDirectory.value + "/bower"),file(baseDirectory.value + "/src/main/" + stage.value))


webInfClasses in webapp := true


Revolver.settings 