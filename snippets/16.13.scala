  val (hashes, duration) = time{
-   for(p <- os.list(os.pwd)) yield {
+   val futures = for(p <- os.list(os.pwd)) yield Future{
      println(p)
      hash(p.last)
    }
+   futures.map(Await.result(_, Duration.Inf))
  }
