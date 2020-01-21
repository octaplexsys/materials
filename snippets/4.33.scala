@ def hello(firstName: String, lastNameOpt: Option[String]) = {
    val lastName = lastNameOpt.getOrElse("")
    println(s"Hello $firstName $lastName")
  }

@ hello("Haoyi", Some("Li"))
Hello Haoyi Li

@ hello("Haoyi", None)
Hello Haoyi
