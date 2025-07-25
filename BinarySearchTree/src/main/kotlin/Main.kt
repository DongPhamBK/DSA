fun main() {
    val tree = BinarySearchTree<Int>()
    tree.insert(3)
    tree.insert(1)
    tree.insert(4)
    tree.insert(0)
    tree.insert(2)
    tree.insert(5)
    println(tree.toString())
    tree.remove(3)
    println(tree)
}