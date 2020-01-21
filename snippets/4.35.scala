@ def hello(firstName: String, lastNameOpt: Option[String]) = {
    val lastNameLengthOpt = lastNameOpt.map(_.length)
    println(s"Hello $firstName lastNameLength: ${lastNameLengthOpt.getOrElse(0)}")
  }

@ hello("Haoyi", Some("Li"))
Hello Haoyi lastNameLength: 2

@ hello("Haoyi", None)
Hello Haoyi lastNameLength: 0
