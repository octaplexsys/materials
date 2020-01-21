@ Array(1, 2, 3, 4, 5).slice<tab>
def slice(from: Int, until: Int): Array[A]

@ Array(1, 2, 3, 4, 5).groupBy<tab>
def groupBy[K](f: A => K): scala.collection.immutable.Map[K,Array[A]]
