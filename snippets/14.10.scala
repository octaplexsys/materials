-   def hello() = {
-     "Hello World!"
-   }
+   def hello() = doctype("html")(
+     html(
+       head(),
+       body(
+         h1("Hello!"),
+         p("World")
+       )
+     )
+   )
