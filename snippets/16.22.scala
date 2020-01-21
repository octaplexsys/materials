-       val nextTitleLists = for(title <- currentTitles) yield fetchLinks(title)
+       val futures = for(title <- currentTitles) yield Future{ fetchLinks(title) }
+       val nextTitleLists = futures.map(Await.result(_, Duration.Inf))
