Global / onChangedBuildSource := ReloadOnSourceChanges

inThisBuild(
  Seq(
    scalaVersion     := "2.13.10",
    version          := "0.1.0-SNAPSHOT",
    organization     := "com.github.mf42-dzh",
    organizationName := "github",
    scalacOptions   ++= Seq("-deprecation", "-unchecked", "-feature")
  )
)

// Warning: currently uses the snapshot locally listed on the developer's computer.
lazy val root = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .withoutSuffixFor(JVMPlatform)
  .crossType(CrossType.Full)
  .in(file("conui"))
  .jvmSettings(
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
  )
  .settings(
    name                := "parsley-debug-conui",
    resolvers          ++= Opts.resolver.sonatypeOssSnapshots,
    libraryDependencies += "com.github.j-mie6" %% "parsley"       % "4.4-de8306a-SNAPSHOT",
    libraryDependencies += "com.github.j-mie6" %% "parsley-debug" % "4.4-de8306a-SNAPSHOT",
    libraryDependencies += "org.scalatest"     %% "scalatest"     % "3.2.15" % Test
  )
