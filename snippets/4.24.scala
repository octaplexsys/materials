@ def isValidSudoku(grid: Array[Array[Int]]) = {
    Range(0, 9).forall{i =>
      val row = Range(0, 9).map(grid(i)(_))
      val col = Range(0, 9).map(grid(_)(i))
      val square = Range(0, 9).map(j => grid((i % 3) * 3 + j % 3)((i / 3) * 3 + j / 3))
      row.distinct.length == row.length &&
      col.distinct.length == col.length &&
      square.distinct.length == square.length
    }
  }
