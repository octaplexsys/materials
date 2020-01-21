@ val (hashes, duration) = time{
    val futures = for(p <- os.list(os.pwd)) yield Future{
      println(p)
      hash(p.last)
    }
    futures.map(Await.result(_, Duration.Inf))
  }
/Users/lihaoyi/test/Chinatown.jpg
/Users/lihaoyi/test/Memorial.jpg
/Users/lihaoyi/test/ZCenter.jpg
/Users/lihaoyi/test/Kresge.jpg
hashes: IndexedSeq[String] = ArraySeq(
  "$2a$17$Q1Hja0bjGCDzXEjyZ1HnbONUpptXyNWzbBAGBova./X/006L3jnWK",
  "$2a$17$T0DxYEjsX1PtZg/LXUztaeL9g3FCdhHQMXPdu5XhJwZtJi.uFYYvC",
  "$2a$17$O0fnZkDyZ1bsJinOPw.eG.H80jYKe4v1rAF8k5sH9uRue4tma50rK",
  "$2a$17$Ug/BXU3yXVGsQj/FGA.eG.yGE9W7lN3LTKfb1qZss.QTgWb13d7o."
)
duration: FiniteDuration = 10292549149 nanoseconds
