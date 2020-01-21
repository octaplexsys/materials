    def callAgent[T: upickle.default.Reader](Rpc: Rpc): T = {
      Rpc.writeRpc(agent.stdin.data, rpc)
      Rpc.readRpc[T](agent.stdout.data)
    }
+   for(srcSubPath <- os.walk(src)) {
+     val subPath = srcSubPath.subRelativeTo(src)
+     (os.isDir(srcSubPath), callAgent[Boolean](Rpc.IsDir(subPath))) match{
+       case (false, true) =>
+         callAgent[Unit](Rpc.WriteOver(os.read.bytes(srcSubPath), subPath))
+       case (true, false) =>
+         for(p <- os.walk(srcSubPath) if os.isFile(p)){
+           callAgent[Unit](Rpc.WriteOver(os.read.bytes(p), p.subRelativeTo(src)))
+         }
+       case (false, false)
+         if !callAgent[Boolean](Rpc.Exists(subPath))
+         || !os.read.bytes(srcSubPath).sameElements(
+              callAgent[Array[Byte]](Rpc.ReadBytes(subPath))
+            ) =>
+         callAgent[Unit](Rpc.WriteOver(os.read.bytes(srcSubPath), subPath))
+       case _ => // do nothing
+     }
+   }
  }
