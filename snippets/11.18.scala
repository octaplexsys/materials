- def callAgent[T: upickle.default.Reader](Rpc: Rpc): T = {
+ def callAgent[T: upickle.default.Reader](Rpc: Rpc): () => T = {
   Rpc.writeRpc(agent.stdin.data, rpc)
-  Rpc.readRpc[T](agent.stdout.data)
+  () => Rpc.readRpc[T](agent.stdout.data)
 }
