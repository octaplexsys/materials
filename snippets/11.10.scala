// agent/src/Agent.scala
package sync
object Agent {
  def main(args: Array[String]): Unit = {
    val dest = os.Path(args(0), os.pwd)
    val bytesIn = new java.io.DataInputStream(System.in)
    val bytesOut = new java.io.DataOutputStream(System.out)
    while(true) try{
      val rpc = Rpc.readRpc[Rpc](bytesIn)
    }catch{case e: java.io.EOFException => System.exit(0)}
  }
}
