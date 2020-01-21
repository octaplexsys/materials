// Batch.sc
import $ivy.`com.lihaoyi::castor:0.1.1`

class UploadBatchActor()(implicit ac: castor.Context)
extends castor.BatchActor[String]{
  @volatile var responseCount = 0
  def runBatch(msgs: Seq[String]) = {
    val res = requests.post("https://httpbin.org/post", data = msgs.mkString)
    responseCount += 1
    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}

implicit val cc = new castor.Context.Test()
val batchUploader = new UploadBatchActor()
// Usage
println("sending hello")
batchUploader.send("hello")

println("sending world")
batchUploader.send("world")

println("sending !")
batchUploader.send("!")

ac.waitForInactivity()

// Validation

assert(batchUploader.responseCount == 1)