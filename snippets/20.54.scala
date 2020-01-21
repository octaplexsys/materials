 def serialize(v: Value): String = v match{
-  case Value.Str(s) => ???
+  case Value.Str(s) => "\"" + s + "\""
   case Value.Dict(kvs) => ???
 }
