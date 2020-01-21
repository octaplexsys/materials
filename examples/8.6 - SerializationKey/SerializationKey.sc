// SerializationKey.sc
val jsonString = os.read(os.pwd / "ammonite-releases.json")

val data = ujson.read(jsonString)

case class Author2(login: String,
                   id: Int,
                   @upickle.implicits.key("site_admin") siteAdmin: Boolean)

implicit val author2RW = upickle.default.macroRW[Author2]

val author2 = upickle.default.read[Author2](data(0)("author"))

assert(pprint.log(author2) == Author2("Ammonite-Bot", 20607116, false))

assert(
  pprint.log(upickle.default.write(author2)) ==
  """{"login":"Ammonite-Bot","id":20607116,"site_admin":false}"""
)
