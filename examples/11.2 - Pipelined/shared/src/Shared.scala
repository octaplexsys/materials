// shared/src/Shared.scala
package sync
import upickle.default.{readwriter, ReadWriter, macroRW}
sealed trait Rpc
object Rpc{
  implicit val relPathRW = readwriter[String].bimap[os.RelPath](_.toString, os.RelPath(_))

  case class IsDir(path: os.RelPath) extends Rpc
  implicit val isDirRw: ReadWriter[IsDir] = macroRW

  case class Exists(path: os.RelPath) extends Rpc
  implicit val existsRw: ReadWriter[Exists] = macroRW

  case class ReadBytes(path: os.RelPath) extends Rpc
  implicit val readBytesRw: ReadWriter[ReadBytes] = macroRW

  case class WriteOver(src: Array[Byte], path: os.RelPath) extends Rpc
  implicit val copyOverRw: ReadWriter[WriteOver] = macroRW

  implicit val rpcRw: ReadWriter[Rpc] = macroRW

  def writeRpc[T: upickle.default.Writer](out: java.io.DataOutputStream, msg: T): Unit = {
    val bytes = upickle.default.writeBinary(msg)
    out.writeInt(bytes.length)
    out.write(bytes)
    out.flush()
  }

  def readRpc[T: upickle.default.Reader](in: java.io.DataInputStream) = {
    val buf = new Array[Byte](in.readInt())
    in.readFully(buf)
    upickle.default.readBinary[T](buf)
  }
}