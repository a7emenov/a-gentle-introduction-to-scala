def saveValue(key: String, value: Int): IO[Unit] = ???

def getValue(key: String): IO[Option[Int]] = ???

def rateLimit[A](program: IO[A]): IO[A] = ???

val program: IO[Option[Int]] = 
  ratelimit(
    saveValue("key", 1) >> getValue("key")
  )

val result: Option[Int] = program.runSyncUnsafe()