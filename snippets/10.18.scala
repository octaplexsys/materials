 os.write(
   os.pwd / "out" / "index.html",
   doctype("html")(
     html(
       head(bootstrapCss),
       body(
         h1("Blog"),
         for((_, suffix, _) <- postInfo)
-         yield h2(suffix)
+         yield h2(a(href := ("post/" + mdNameToHtml(suffix)), suffix))
       )
     )
   )
 )
