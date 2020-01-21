def add(s: String) = {
  var current = root
  for(c <- s) current = current.children.get(c) match{
    case Some(child) => child
    case None =>
      val child = new Node(false)
      current.children(c) = child
      child
  }
  current.hasValue = true
}
