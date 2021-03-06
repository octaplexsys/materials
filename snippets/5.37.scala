// SearchPaths.sc
def searchPaths[T](start: T, graph: Map[T, Seq[T]]): Map[T, List[T]] = {
  val seen = collection.mutable.Map(start -> List(start))
  val queue = collection.mutable.Queue(start -> List(start))
  while(queue.nonEmpty){
    val (current, path) = queue.dequeue()
    for(next <- graph(current) if !seen.contains(next)){
      val newPath = next :: path
      seen(next) = newPath
      queue.enqueue((next, newPath))
    }
  }
  seen.toMap
}
