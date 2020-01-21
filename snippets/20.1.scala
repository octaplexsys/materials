def evaluate(expr: Expr, scope: Map[String, Value]): Value = expr match{
  case Expr.Str(s) => Value.Str(s)
  case Expr.Dict(kvs) => Value.Dict(kvs.map{case (k, v) => (k, evaluate(v, scope))})
  case Expr.Plus(items) =>
    Value.Str(items.map(evaluate(_, scope)).map{case Value.Str(s) => s}.mkString)
  case Expr.Local(name, assigned, body) =>
    val assignedValue = evaluate(assigned, scope)
    evaluate(body, scope + (name -> assignedValue))
  case Expr.Ident(name) => scope(name)
}
