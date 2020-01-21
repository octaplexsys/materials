@ def fetchAllLinks(startTitle: String, depth: Int) = {
    var seen = Set(startTitle)
    var currentTitles = Set(startTitle)
    for(i <- 0 until depth){
      val nextTitleLists = for(title <- currentTitles) yield fetchLinks(title)
      currentTitles = nextTitleLists.flatten.filter(!seen.contains(_))
      seen = seen ++ currentTitles
    }
    seen
  }
