val agentReader = new Thread(() => {
  while(agent.isAlive()){
    SyncActor.send(AgentResponse(Rpc.readRpc[Rpc.StatInfo](agent.stdout.data)))
  }
})
agentReader.start()

os.watch.watch(
  Seq(src),
  onEvent = _.foreach(p => SyncActor.send(ChangedPath(p.subRelativeTo(src))))
)

Thread.sleep(999999)
