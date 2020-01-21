@ val gitLog = os.proc("git", "log").call().out.text()
gitLog: String = """commit 160bf840ec70756b1dc0ea06036ada5a9993cd7f
Author: Li Haoyi
Date:   Mon Jun 3 09:32:05 2019 +0800

    tweaks

commit 32ccf9fe457f625243abf6903fd6095ff8d825c3
Author: Li Haoyi
Date:   Mon Jun 3 09:27:14 2019 +0800
...
