// UploadSimpleActor.sc
import $ivy.`com.lihaoyi::castor:0.1.1`
class UploadSimpleActor()(implicit ac: castor.Context) extends castor.SimpleActor[String]{
  def run(msg: String) = {
    println(s"Uploading $msg")
    val res = requests.post("https://httpbin.org/post", data = msg)
    println(s"response ${res.statusCode} " + ujson.read(res.text())("data"))
  }
}

import castor.Context.Simple.global
val uploader = new UploadSimpleActor()
