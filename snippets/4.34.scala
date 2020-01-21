@ def hello(firstName: String, lastNameOpt: Option[String]) = {
    for(lastName <- lastNameOpt) println(s"lastName: $lastName")
    println(s"Hello $firstName")
  }

@ hello("Haoyi", Some("Li"))
lastName: Li
Hello Haoyi

@ hello("Haoyi", None)
Hello Haoyi
