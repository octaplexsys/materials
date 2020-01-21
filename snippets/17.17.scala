// LoggingLongPipeline.sc
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
class Uploader(url: String)(implicit ac: castor.Context)
extends castor.SimpleActor[String]{
  def run(msg: String) = {
    val res = requests.post(url, data = msg)
    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}
class Encoder(dests: Seq[castor.Actor[String]])
             (implicit ac: castor.Context) extends castor.SimpleActor[String]{
  def run(msg: String) = {
    val encoded = java.util.Base64.getEncoder.encodeToString(msg.getBytes)
    for(dest <- dests) dest.send(encoded)
  }
}
class Logger(dest: castor.Actor[String])
            (implicit ac: castor.Context) extends castor.SimpleActor[String]{
  def run(msg: String) = {
    dest.send(msg.replaceAll("([0-9]{4})[0-9]{8}([0-9]{4})", "<redacted>"))
  }
}
