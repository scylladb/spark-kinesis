lazy val root = (project in file("."))
  .settings(
    Seq(
      organization := "org.apache.spark",
      name := "spark-streaming-kinesis-asl",
      version := "2.4.4",
      scalaVersion := "2.11.12",
      libraryDependencies ++= Seq(
        "org.apache.sparK" %% "spark-streaming" % "2.4.4" % "provided",
        "com.amazonaws" % "dynamodb-streams-kinesis-adapter" % "1.5.2",
        "com.amazonaws" % "aws-java-sdk-sts" % "1.11.728",
        "com.amazonaws" % "amazon-kinesis-producer" % "0.14.0" % "test",
        "org.scalatest" %% "scalatest" % "3.0.3" % "test",
        "org.scalacheck" %% "scalacheck" % "1.13.5" % "test",
        "org.apache.spark" %% "spark-core" % "2.4.4" % "test" classifier "tests",
        "org.apache.spark" %% "spark-streaming" % "2.4.4" % "test" classifier "tests",
        "junit" % "junit" % "4.12" % "test",
        "org.mockito" % "mockito-core" % "1.10.19" % "test"
      ),
      assembly / test := {}
    )
  )
