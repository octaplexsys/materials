// build.sc
import mill._

def srcs = T.source(millSourcePath / "src")

def concat = T{
  os.write(
    T.dest / "concat.txt",
    for(p <- os.walk(srcs().path) if os.isFile(p)) yield os.read(p)
  )
  PathRef(T.dest / "concat.txt")
}