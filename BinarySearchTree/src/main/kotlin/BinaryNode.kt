/**
 * Định nghĩa node cho cây nhị phân
 * Bao gồm node trái và node phải
 */
class BinaryNode<T>(var value: T) {
    var leftChild: BinaryNode<T>? = null //Node trái
    var rightChild: BinaryNode<T>? = null//Node phải

    val min: BinaryNode<T>? get() = leftChild?.min ?: this
    override fun toString() = diagram(this)

    private fun diagram(node: BinaryNode<T>?, top: String = "", root: String = "", bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") + root + "${node.value}\n" +
                        diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    /**
     * Duyệt gữa
     */
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    /**
     * Duyệt trước
     */

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    /**
     * Duyệt sau
     */
    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
}

typealias Visitor<T> = (T) -> Unit //Duyệt cây