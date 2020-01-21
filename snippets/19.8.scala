val agentExecutable = os.temp(os.read.bytes(os.resource / "agent.jar"))
os.perms.set(agentExecutable, "rwx------")
val agent = os.proc(agentExecutable, args(1)).spawn(stderr = os.Inherit)
