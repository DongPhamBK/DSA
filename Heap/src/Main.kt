fun main() {
    val heap = Heap()
    heap.insert(10)
    heap.insert(0)
    heap.insert(1)
    heap.insert(15)
    heap.insert(25)
    heap.insert(115)
    heap.insert(7)
    heap.deleteMax()
    println(heap.toString())
}