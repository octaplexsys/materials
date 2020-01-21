// UploadBatchActor.sc
import $ivy.`com.lihaoyi::castor:0.1.1`
class UploadBatchActor()(implicit ac: castor.Context) extends castor.BatchActor[String]{
  def runBatch(msgs: Seq[String]) = {
    println(s"Uploading ${msgs.mkString}")
    val res = requests.post("https://httpbin.org/post", data = msgs.mkString)
    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}
import castor.Context.Simple.global
val batchUploader = new UploadBatchActor()
