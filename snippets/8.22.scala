@ println(ujson.write(data(0)("author"), indent = 4))
{
    "login": "Ammonite-Bot",
    "id": 20607116,
    "node_id": "MDQ6VXNlcjIwNjA3MTE2",
    "gravatar_id": "",
    "type": "User",
    "site_admin": false
}

@ case class Author(login: String, id: Int, site_admin: Boolean)

@ implicit val authorRW = upickle.default.macroRW[Author]
