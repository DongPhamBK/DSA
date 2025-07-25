fun main() {
    val priorityQueue = PriorityQueue<Int>()
    priorityQueue.enqueue(10, 1)
    priorityQueue.enqueue(5, 2)
    println(priorityQueue) // 10(1), 5(2)
    println(priorityQueue.dequeue()) // 10
    println(priorityQueue) // 5(2)
}