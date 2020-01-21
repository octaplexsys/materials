// build.sc
  import mill._
+ trait FooModule extends Module{
    def srcs = T.source(...)
    def resources = T.source(...)

    def concat = T{ ... }
    def compress = T{ ... }
    def zipped = T{ ... }
+ }
+
+ object bar extends FooModule
+ object qux extends FooModule
