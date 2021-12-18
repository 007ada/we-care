name := """we-care-io"""
organization := "com.we-caew"

version := "1.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.5"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "org.postgresql" % "postgresql" % "42.2.5" //org.postgresql.ds.PGSimpleDataSource dependency
)

sources in (Compile, doc) := Seq.empty

publishArtifact in (Compile, packageDoc) := false

mainClass in assembly := Some("play.core.server.ProdServerStart")
fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value)

assemblyMergeStrategy in assembly := {
  case manifest if manifest.contains("MANIFEST.MF") =>
    // We don't need manifest files since sbt-assembly will create
    // one with the given settings
    MergeStrategy.concat
  case referenceOverrides if referenceOverrides.contains("reference-overrides.conf") =>
    // Keep the content for all reference-overrides.conf files
    MergeStrategy.concat
  case x =>
    // For all the other files, use the default sbt-assembly merge strategy
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

 //Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.we-caew.controllers._"

 //Adds additional packages into conf/routes
 //play.sbt.routes.RoutesKeys.routesImport += "com.we-caew.binders._"
