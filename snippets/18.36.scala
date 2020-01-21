- for (suffix <- links())
- yield h2(a(href := ("post/" + mdNameToHtml(suffix)))(suffix))
+ for ((suffix, preview) <- links().zip(previews()))
+ yield frag(
+   h2(a(href := ("post/" + mdNameToHtml(suffix)))(suffix)),
+   raw(preview)
+ )
