@ val (nextLinks, duration) = time{
    val futures = for (link <- links) yield Future{ fetchLinks(link) }
    futures.map(Await.result(_, Duration.Inf))
  }
nextLinks: Seq[Iterable[String]] = List(
  List(
    "20th Century Press Archives",
    "2dF Galaxy Redshift Survey",
    ...
    "Abdus Salam",
    "Absent-minded professor"
  ),
  List(
    "20th Century Press Archives",
    "2dF Galaxy Redshift Survey",
...
duration: FiniteDuration = 622621511 nanoseconds
