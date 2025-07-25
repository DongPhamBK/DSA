fun main() {
    val linkedListStack = LinkedListStack<Int>()
    linkedListStack.push(0)
    linkedListStack.push(5)
    linkedListStack.push(18)
    println(linkedListStack) // 18 -> 5 -> 0 -> null
    println(linkedListStack.peek()) // 18
    linkedListStack.push(100)
    println(linkedListStack.peek()) // 100
}