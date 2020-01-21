@ val a = collection.mutable.ArrayDeque(1, 2, 3, 4, 5)
a: mutable.ArrayDeque[Int] = ArrayDeque(1, 2, 3, 4, 5)

@ a.removeHead()
res230: Int = 1

@ a
res232: mutable.ArrayDeque[Int] = ArrayDeque(2, 3, 4, 5)

@ a.append(6)
res233: mutable.ArrayDeque[Int] = ArrayDeque(2, 3, 4, 5, 6)

@ a.removeLast()
res237: Int = 6

@ a
res238: mutable.ArrayDeque[Int] = ArrayDeque(2, 3, 4, 5)

@ a.prepend(1)
res239: mutable.ArrayDeque[Int] = ArrayDeque(1, 2, 3, 4, 5)

@ a(0)
res241: Int = 1

@ a(3)
res242: Int = 4

@ a(1) = -10

@ a
res245: mutable.ArrayDeque[Int] = ArrayDeque(1, -10, 3, 4, 5)
