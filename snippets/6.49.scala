@ for(srcSubPath <- srcContents) {
    val destSubPath = dest / srcSubPath.relativeTo(src)
    (os.isDir(srcSubPath), os.isDir(destSubPath)) match{
      case (false, true) | (true, false) =>
        os.copy.over(srcSubPath, destSubPath, createFolders = true)
      case (false, false)
        if !os.exists(destSubPath)
        || !os.read.bytes(srcSubPath).sameElements(os.read.bytes(destSubPath)) =>

        os.copy.over(srcSubPath, destSubPath, createFolders = true)

      case _ => // do nothing
    }
  }
