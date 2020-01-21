   @cask.postForm("/")
   def postHello(name: String, msg: String) = {
+    if (name != "" && msg != ""){
       messages = messages :+ (name -> msg)
+    }
     hello()
   }
