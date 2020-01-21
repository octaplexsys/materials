@ val gitBranchLines = os.proc("git", "branch").call().out.lines()
gitBranchLines: Vector[String] = Vector("* master")
