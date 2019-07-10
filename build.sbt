enablePlugins(PackPlugin)

scalaVersion in ThisBuild := "2.12.8"

val AIRFRAME_VERSION = "19.7.1"

libraryDependencies ++= Seq(
  "org.wvlet.airframe" %% "airframe-launcher" % AIRFRAME_VERSION,
  "org.wvlet.airframe" %% "airframe-http-finagle" % AIRFRAME_VERSION
)
