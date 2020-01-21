// GenericMergeSort.sc
def mergeSort[T: Ordering](items: IndexedSeq[T]): IndexedSeq[T] = {
  if (items.length <= 1) items
  else {
    val (left, right) = items.splitAt(items.length / 2)
    val sortedLeft = mergeSort(left)
    val sortedRight = mergeSort(right)
    var leftIdx = 0
    var rightIdx = 0
    val output = IndexedSeq.newBuilder[T]
    while(leftIdx < sortedLeft.length || rightIdx < sortedRight.length){
      val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match{
        case (true, false) => true
        case (false, true) => false
        case (true, true) => Ordering[T].lt(sortedLeft(leftIdx), sortedRight(rightIdx))
      }
      if (takeLeft){
        output += sortedLeft(leftIdx)
        leftIdx += 1
      }else{
        output += sortedRight(rightIdx)
        rightIdx += 1
      }
    }
    output.result()
  }
}
// Usage
val input = Vector("banana", "mandarin", "avocado", "apple", "mango", "cherry", "mangosteen")
pprint.log(input)
assert(
  pprint.log(mergeSort(input)) ==
  Vector("apple", "avocado", "banana", "cherry", "mandarin", "mango", "mangosteen")
)

