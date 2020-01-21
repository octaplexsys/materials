package app
object MinimalApplication extends cask.MainRoutes{
  @cask.post("/do-thing")
  def doThing(request: cask.Request) = {
    request.text().reverse
  }

  initialize()
}
