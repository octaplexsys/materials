@ val myPath = os.pwd
myPath: os.Path = /Users/lihaoyi/test

@ myPath.segments.toList
res19: List[String] = List("Users", "lihaoyi", "Github", "blog")

@ myPath.last
res20: String = "blog"
