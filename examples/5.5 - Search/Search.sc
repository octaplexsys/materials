// Search.sc
def search[T](start: T, graph: Map[T, Seq[T]]): Set[T] = {
  val seen = collection.mutable.Set(start)
  val queue = collection.mutable.Queue(start)
  while(queue.nonEmpty){
    val current = queue.dequeue()
    for(next <- graph(current) if !seen(next)){
      seen.add(next)
      queue.enqueue(next)
    }
  }
  seen.toSet
}
// Usage
assert(
  pprint.log(
    search(
      start = "c",
      graph = Map(
        "a" -> Seq("b", "c"),
        "b" -> Seq("a"),
        "c" -> Seq("b")
      )
    )
  ) ==
  Set("a", "b", "c")
)

assert(
  pprint.log(
    search(
      start = "a",
      graph = Map(
        "a" -> Seq("b", "c"),
        "b" -> Seq("c", "d"),
        "c" -> Seq("d"),
        "d" -> Seq()
      )
    )
  ) ==
  Set("a", "b", "c", "d")
)

assert(
  pprint.log(
    search(
      start = "c",
      graph = Map(
        "a" -> Seq("b", "c"),
        "b" -> Seq("c", "d"),
        "c" -> Seq("d"),
        "d" -> Seq()
      )
    )
  ) ==
  Set("c", "d")
)