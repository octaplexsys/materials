// sync/src/Sync.scala
package sync
object Sync {
  def main(args: Array[String]): Unit = {
    val src = os.Path(args(0), os.pwd)

    val agentExecutable = os.temp(os.read.bytes(os.resource / "agent.jar"))
    os.perms.set(agentExecutable, "rwx------")
    val agent = os.proc(agentExecutable, args(1)).spawn()
    def callAgent[T: upickle.default.Reader](rpc: Rpc): () => T = {
      Rpc.writeRpc(agent.stdin.data, rpc)
      () => Rpc.readRpc[T](agent.stdout.data)
    }
    val subPaths = os.walk(src).map(_.relativeTo(src))
    def pipelineCalls[T: upickle.default.Reader](rpcFor: os.RelPath => Option[Rpc]) = {
      val buffer = collection.mutable.Buffer.empty[(os.RelPath, () => T)]
      for(sub <- subPaths; rpc <- rpcFor(sub)) buffer.append((sub, callAgent[T](rpc)))
      buffer.map{case (k, v) => (k, v())}.toMap
    }

    val existsMap = pipelineCalls[Boolean](sub => Some(Rpc.Exists(sub)))
    val isDirMap = pipelineCalls[Boolean](sub => Some(Rpc.IsDir(sub)))

    val readMap = pipelineCalls[Array[Byte]]{sub =>
      if (existsMap(sub) && !isDirMap(sub)) Some(Rpc.ReadBytes(sub))
      else None
    }

    pipelineCalls[Unit]{ sub =>
      if (os.isDir(src / sub)) None
      else{
        val localBytes = os.read.bytes(src / sub)
        if (readMap.get(sub).exists(java.util.Arrays.equals(_, localBytes))) None
        else Some(Rpc.WriteOver(localBytes, sub))
      }
    }
  }
}
