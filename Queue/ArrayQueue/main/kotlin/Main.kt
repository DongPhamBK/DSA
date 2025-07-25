fun main() {
    val linkedListQueue = LinkedListQueue<Int>()
    linkedListQueue.enqueue(1)
    linkedListQueue.enqueue(2)
    linkedListQueue.enqueue(3)
    println(linkedListQueue.peek()) // 1
    println(linkedListQueue) // 1 -> 2 -> 3 -> null
}