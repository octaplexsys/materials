       messages = messages :+ (name -> msg)
+      for(conn <- openConnections) conn.send(cask.Ws.Text(messageList().render))
       ujson.Obj("success" -> true, "txt" -> messageList().render)
