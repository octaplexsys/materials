@ {
  val gitLog = os.proc("git", "log").spawn()
  val grepAuthor = os.proc("grep", "Author: ").spawn(stdin = gitLog.stdout)
  val distinct = collection.mutable.LinkedHashSet.empty[String]
  while(grepAuthor.stdout.available() > 0 || grepAuthor.isAlive()){
    distinct.add(grepAuthor.stdout.readLine())
  }
  }
distinct: collection.mutable.LinkedHashSet[String] = Set(
  "Author: Li Haoyi",
  "Author: Guillaume Galy",
  "Author: Nik Vanderhoof",
...
