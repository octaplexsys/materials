def writeRpc[T: upickle.default.Writer](out: java.io.DataOutputStream, msg: T): Unit = {
  val bytes = upickle.default.writeBinary(msg)
  out.writeInt(bytes.length)
  out.write(bytes)
  out.flush()
}
