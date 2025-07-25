import java.util.Queue
import java.util.Stack

fun main() {
    val singlyLinkedList = SinglyLinkedList<Int>()
    println(singlyLinkedList)
    singlyLinkedList.push(99)
    singlyLinkedList.append(10)
    singlyLinkedList.append(8)
    singlyLinkedList.append(5)

    singlyLinkedList.append(1)
    println(singlyLinkedList) //99 -> 10 -> 8 -> 5 -> 1 -> null
    val reservedSinglyLinkedList = singlyLinkedList.reserve2()
    println(reservedSinglyLinkedList) //1 -> 5 -> 8 -> 10 -> 99 -> null

}