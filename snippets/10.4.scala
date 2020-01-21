// Blog.sc
val postInfo = os
  .list(os.pwd / "post")
  .flatMap{ p =>
    p.last.split(" - ") match{
      case Array(prefix, suffix) => Some((prefix, suffix, p))
      case _ => None
    }
  }
  .sortBy(_._1.toInt)

println("POSTS")
postInfo.foreach(println)
