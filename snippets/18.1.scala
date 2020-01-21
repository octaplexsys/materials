def sources = T.source(os.pwd / "src")

def concat = T{
  os.write(
    T.dest / "concat.txt",
    for(p <- os.walk(sources().path) if os.isFile(p))
    yield os.read(p)
  )
  PathRef(T.dest / "concat.txt")
}
