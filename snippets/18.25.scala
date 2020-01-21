// build.sc
import $ivy.`com.lihaoyi::scalatags:0.8.4`, scalatags.Text.all._
import $ivy.`com.atlassian.commonmark:commonmark:0.13.1`
import mill._
interp.watch(os.pwd / "post")
val postInfo = os
  .list(os.pwd / "post")
  .flatMap{ p =>
    p.last.split(" - ") match{
      case Array(prefix, suffix) => Some((prefix, suffix.stripSuffix(".md"), p))
      case _ => None
    }
  }
  .sortBy(_._1.toInt)

def mdNameToHtml(name: String) = name.replace(" ", "-").toLowerCase + ".html"

val bootstrapCss = link(
  rel := "stylesheet",
  href := "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css"
)

object post extends Cross[PostModule](postInfo.map(_._1):_*)
class PostModule(number: String) extends Module{
  val Some((_, suffix, markdownPath)) = postInfo.find(_._1 == number)
  def path = T.source(markdownPath)
  def render = T{
    val parser = org.commonmark.parser.Parser.builder().build()
    val document = parser.parse(os.read(path().path))
    val renderer = org.commonmark.renderer.html.HtmlRenderer.builder().build()
    val output = renderer.render(document)
    os.write(
      os.pwd / "out" / "post" / mdNameToHtml(suffix),
      doctype("html")(
        html(
          head(bootstrapCss),
          body(
            h1(a("Blog", href := "../index.html"), " / ", suffix),
            raw(output)
          )
        )
      )
    )
  }
}
def links = T.input{ postInfo.map(_._2) }
def index = T{
  os.write(
    T.dest / "index.html",
    doctype("html")(
      html(
        head(bootstrapCss),
        body(
          h1("Blog"),
          for (suffix <- links())
          yield h2(a(suffix, href := ("post/" + mdNameToHtml(suffix))))
        )
      )
    )
  )
  PathRef(T.dest / "index.html")
}

val posts = T.sequence(postInfo.map(_._1).map(post(_).render))

def dist = T {
  for (post <- posts()) {
    os.copy(post.path, T.dest / "post" / post.path.last, createFolders = true)
  }
  os.copy(index().path, T.dest / "index.html")

  PathRef(T.dest)
}
