// agent/src/Agent.scala
     while(true) try {
+      val rpc = Rpc.readRpc[Rpc](bytesIn)
+      rpc match{
+        case Rpc.IsDir(path) => Rpc.writeRpc(bytesOut, os.isDir(dest / path))
+        case Rpc.Exists(path) => Rpc.writeRpc(bytesOut, os.exists(dest / path))
+        case Rpc.ReadBytes(path) => Rpc.writeRpc(bytesOut, os.read.bytes(dest / path))
+        case Rpc.WriteOver(bytes, path) =>
+          os.remove.all(dest / path)
+          Rpc.writeRpc(bytesOut, os.write.over(dest / path, bytes, createFolders = true))
+      }
     } catch{case e: java.io.EOFException => System.exit(0)}
   }
 }
