object SyncActor extends castor.SimpleActor[Msg]{
  def run(msg: Msg): Unit = msg match{
    case ChangedPath(value) => Rpc.writeRpc(agent.stdin.data, Rpc.StatPath(value))
    case AgentResponse(Rpc.StatInfo(p, remoteHash)) =>
      val localHash = Rpc.hashFromPath(src / p)
      if (localHash != remoteHash && localHash.isDefined){
        Rpc.writeRpc(agent.stdin.data, Rpc.WriteOver(os.read.bytes(src / p), p))
      }
  }
}
