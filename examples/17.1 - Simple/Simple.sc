// Simple.sc
import $ivy.`com.lihaoyi::castor:0.1.1`

class UploadSimpleActor()(implicit ac: castor.Context)
extends castor.SimpleActor[String]{
  var count = 0
  def run(msg: String) = {
    println(s"Uploading $msg")
    val res = requests.post("https://httpbin.org/post", data=msg)
    count += 1
    println(s"response $count ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}

implicit val cc = new castor.Context.Test()
val uploader = new UploadSimpleActor()

// Usage
println("sending hello")
uploader.send("hello")

println("sending world")
uploader.send("world")

println("sending !")
uploader.send("!")

ac.waitForInactivity()

// Validation

synchronized(assert(uploader.count == 3))