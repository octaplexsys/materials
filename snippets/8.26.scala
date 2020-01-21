@ case class Author(login: String,
                    id: Int,
                    @upickle.implicits.key("site_admin") siteAdmin: Boolean)

@ implicit val authorRW = upickle.default.macroRW[Author]

@ val author = upickle.default.read[Author](data(0)("author"))
author: Author = Author("Ammonite-Bot", 20607116, false)
