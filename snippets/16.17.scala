@ val (nextLinks, duration) = time{
    for (link <- links) yield fetchLinks(link)
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
duration: FiniteDuration = 4125358026 nanoseconds
