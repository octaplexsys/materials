@ def fetchAllLinksParallel(startTitle: String, depth: Int) = {
    var seen = Set(startTitle)
    var currentTitles = Set(startTitle)
    for(i <- 0 until depth){
      val futures = for(title <- currentTitles) yield Future{ fetchLinks(title) }
      val nextTitleLists = futures.map(Await.result(_, Duration.Inf))
      currentTitles = nextTitleLists.flatten.filter(!seen.contains(_))
      seen = seen ++ currentTitles
    }
    seen
  }
