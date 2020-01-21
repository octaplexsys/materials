@ val authorLines = os.proc("grep", "Author: ").call(stdin = gitLog).out.lines()
authorLines: Vector[String] = Vector(
  "Author: Li Haoyi",
  "Author: Li Haoyi",
  "Author: Li Haoyi",
...
