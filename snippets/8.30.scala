@ case class Asset(id: Int, name: String, uploader: ujson.Value)

@ implicit val assetRW = upickle.default.macroRW[Asset]

@ val assets = upickle.default.read[Seq[Asset]](data(0)("assets"))
assets: Seq[Asset] = List(
  Asset(
    13194960,
    "2.12-1.6.8",
    Obj(
      LinkedHashMap(
        "login" -> Str("Ammonite-Bot"),
        "id" -> Num(2.0607116E7),
        "node_id" -> Str("MDQ6VXNlcjIwNjA3MTE2"),
        "gravatar_id" -> Str(""),
        "type" -> Str("User"),
        "site_admin" -> false
      )
    )
  ),
...

@ println(assets(0).uploader.render(indent = 4))
{
    "login":"Ammonite-Bot",
    "id":20607116,
    "node_id":"MDQ6VXNlcjIwNjA3MTE2",
    "gravatar_id":"","type":"User",
    "site_admin":false
}

@ println(assets(0).uploader.obj.keys)
Set(login, id, node_id, gravatar_id, type, site_admin)
