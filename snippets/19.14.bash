$ rm -rf src/*

$ rm -rf dest/*

$ ./mill show sync.assembly
"ref:094ef734:/Users/lihaoyi/test/out/sync/assembly/dest/out.jar"

$ out/sync/assembly/dest/out.jar src dest
