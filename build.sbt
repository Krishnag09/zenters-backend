name := """zenters-backend"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.5"


libraryDependencies ++={
    Seq(
        guice,
        jdbc,
        "mysql" % "mysql-connector-java" % "8.0.28",
        "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
        "com.typesafe.play" %% "play" % "2.8.18",
        "org.scalikejdbc" %% "scalikejdbc-play-initializer" % "2.8.0-scalikejdbc-4.0",
        "org.scalikejdbc" %% "scalikejdbc" % "4.0.0-M1",
        "org.scalikejdbc" %% "scalikejdbc-config" % "4.0.0-M1",
        "com.typesafe.slick" %% "slick" % "3.4.0-M1",
        "org.mindrot" % "jbcrypt" % "0.4",

        
    )
}


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
