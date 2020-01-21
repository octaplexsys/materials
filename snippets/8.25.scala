@ os.write(os.pwd / "author.json", upickle.default.stream(author))

@ os.read(os.pwd / "author.json")
res7: String = "{\"login\":\"Ammonite-Bot\",\"id\":20607116,\"site_admin\":false}"

@ upickle.default.read[Author](os.read.stream(os.pwd / "author.json"))
res8: Author = Author("Ammonite-Bot", 20607116, false)
