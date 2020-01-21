@ val author = upickle.default.read[Author](data(0)("author"))
author: Author = Author("Ammonite-Bot", 20607116, false)

@ author.login
res60: String = "Ammonite-Bot"

@ author.id
res61: Int = 20607116

@ author.site_admin
res62: Boolean = false
