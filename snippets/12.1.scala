@ requests.post(
    "https://api.github.com/repos/lihaoyi/test/issues",
    data = ujson.Obj("title" -> "hello").render(),
    headers = Map("Authorization" -> s"token $token")
  )
res56: requests.Response = Response(
  "https://api.github.com/repos/lihaoyi/test/issues",
  201,
  "Created",
...
