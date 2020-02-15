name := "Starter"

version := "0.1"

scalaVersion := "2.11.5"


libraryDependencies ++= {

  val monixVersion = "3.0.0-RC1"
  val circeVersion    = "0.9.3"

  Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.3.16",
  "com.typesafe.akka" %% "akka-http" % "10.1.11",
  "com.typesafe.akka" %% "akka-stream" % "2.5.26",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.11",
  "io.monix" %% "monix" % monixVersion,
    "ch.megard"                  %% "akka-http-cors"    % "0.3.0",
    "io.circe"                   %% "circe-core"        % circeVersion,
    "io.circe"                   %% "circe-core"        % circeVersion,
    "io.circe"                   %% "circe-generic"     % circeVersion,
    "io.circe"                   %% "circe-parser"      % circeVersion,
    "io.circe"                   %% "circe-java8"       % circeVersion,
    "io.spray"            %% "spray-can"        % "1.3.2",
    "io.spray"            %% "spray-routing"    % "1.3.2",
    "io.spray"            %% "spray-client"     % "1.3.2",
    "io.spray"            %% "spray-json"       % "1.3.2",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.11"

  )
}