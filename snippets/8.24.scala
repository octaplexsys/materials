@ val stringified = upickle.default.write(author)
stringified: String = "{\"login\":\"Ammonite-Bot\",\"id\":20607116,\"site_admin\":false}"

@ println(stringified)
{"login":"Ammonite-Bot","id":20607116,"site_admin":false}

@ val author = upickle.default.read[Author](stringified)
author: Author = Author("Ammonite-Bot", 20607116, false)
