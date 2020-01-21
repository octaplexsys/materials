// Usage
logger.send("I am cow")
logger.send("hear me moo")
logger.send("I weight twice as much as you")
logger.send("And I look good on the barbecue")
logger.send("Yoghurt curds cream cheese and butter")
logger.send("Comes from liquids from my udder")
logger.send("I am cow, I am cow")
logger.send("Hear me moo, moooo")

cc.waitForInactivity()
// Logs are base64 encoded
assert(
  os.read(os.pwd / "log-old.txt") ==
  "Q29tZXMgZnJvbSBsaXF1aWRzIGZyb20gbXkgdWRkZXI=\n"
)
assert(
  os.read(os.pwd / "log.txt") ==
  "SSBhbSBjb3csIEkgYW0gY293\nSGVhciBtZSBtb28sIG1vb29v\n"
)

def decodeFile(p: os.Path) = {
  os.read.lines(p).map(s => new String(java.util.Base64.getDecoder.decode(s)))
}
// When decoded, the contents are what we expect
assert(decodeFile(os.pwd / "log-old.txt") == Seq("Comes from liquids from my udder"))
assert(decodeFile(os.pwd / "log.txt") == Seq("I am cow, I am cow", "Hear me moo, moooo"))
