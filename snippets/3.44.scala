@ val flattened2 = for{
    s <- b
    i <- a
  } yield s + i
flattened2: Array[String] = Array("hello1", "hello2", "world1", "world2")
