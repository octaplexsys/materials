// LoggingPipeline.sc
import $ivy.`com.lihaoyi::castor:0.1.1`
class Writer(log: os.Path, old: os.Path, rotateSize: Int)
            (implicit ac: castor.Context) extends castor.SimpleActor[String]{
  def run(s: String) = {
    val newLogSize = logSize + s.length + 1
    if (newLogSize <= rotateSize) logSize = newLogSize
    else {
      logSize = s.length
      os.move(log, old, replaceExisting = true)
    }
    os.write.append(log, s + "\n", createFolders = true)
  }
  private var logSize = 0
}

class Logger(dest: castor.Actor[String])
            (implicit ac: castor.Context) extends castor.SimpleActor[String]{
  def run(s: String) = dest.send(java.util.Base64.getEncoder.encodeToString(s.getBytes))
}

implicit val cc = new castor.Context.Test()

val writer = new Writer(os.pwd / "log.txt", os.pwd / "log-old.txt", rotateSize = 50)
val logger = new Logger(writer)
