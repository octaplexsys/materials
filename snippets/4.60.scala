@ val m = collection.mutable.Map("one" -> 1, "two" -> 2, "three" -> 3)
m: mutable.Map[String, Int] = HashMap("two" -> 2, "three" -> 3, "one" -> 1)

@ m.contains("two")
res261: Boolean = true

@ m("two")
res262: Int = 2

@ m.remove("two")
res263: Option[Int] = Some(2)

@ m
res264: mutable.Map[String, Int] = HashMap("three" -> 3, "one" -> 1)

@ m("five") = 5

@ m
res266: mutable.Map[String, Int] = HashMap("five" -> 5, "three" -> 3, "one" -> 1)
