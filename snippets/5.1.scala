def breadthFirstSearch[T](start: T, graph: Map[T, Seq[T]]): Set[T] = {
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
