    val agent = os.proc(agentExecutable, args(1)).spawn()
+   def callAgent[T: upickle.default.Reader](Rpc: Rpc): T = {
+     Rpc.writeRpc(agent.stdin.data, rpc)
+     Rpc.readRpc[T](agent.stdout.data)
+   }
  }
