// LoggingSimple.sc
import $ivy.`com.lihaoyi::castor:0.1.1`
class Logger(log: os.Path, old: os.Path, rotateSize: Int)
            (implicit ac: castor.Context) extends castor.SimpleActor[String]{
  def run(s: String) = {
    val newLogSize = logSize + s.length + 1
    if (newLogSize <= rotateSize) logSize = newLogSize
    else { // rotate log file
      logSize = s.length
      os.move(log, old, replaceExisting = true)
    }
    os.write.append(log, s + "\n", createFolders = true)
  }
  private var logSize = 0
}

implicit val cc = new castor.Context.Test()

val logger = new Logger(os.pwd / "log.txt", os.pwd / "log-old.txt", rotateSize = 50)
