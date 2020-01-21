$ amm --class-based
Loading...
Welcome to the Ammonite Repl 2.0.4 (Scala 2.13.1 Java 11.0.2)
@ scala.concurrent.<tab>
Await                            Channel                          Promise
AwaitPermission                  DelayedLazyVal                   SyncChannel
Awaitable                        ExecutionContext                 SyncVar`
BatchingExecutorStatics          ExecutionException               blocking
BlockContext                     Future                           duration
...

@ import scala.concurrent._, duration._, ExecutionContext.Implicits.global
import scala.concurrent._
