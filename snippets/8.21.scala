@ def traverse(v: ujson.Value): Boolean = v match{
    case a: ujson.Arr =>
      a.arr.foreach(traverse)
      true
    case o: ujson.Obj =>
      o.obj.filterInPlace{case (k, v) => traverse(v)}
      true
    case s: ujson.Str => !s.str.startsWith("https://")
    case _ => true
  }

@ traverse(data)

@ ujson.write(data, indent = 4)
res52: String = """[
    {
        "id": 17991367,
        "node_id": "MDc6UmVsZWFzZTE3OTkxMzY3",
        "tag_name": "1.6.8",
        "target_commitish": "master",
        "name": "1.6.8",
        "draft": false,
        "author": {
            "login": "Ammonite-Bot",
...
