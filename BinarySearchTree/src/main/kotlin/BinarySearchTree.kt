class BinarySearchTree<T : Comparable<T>>() {
    var root: BinaryNode<T>? = null //Cây nhị phân


    override fun toString(): String {
        return root?.toString() ?: "Empty tree!"
    }

    /**
     * Thao tác chèn
     */
    fun insert(value: T) {
        root = _insert(root, value)
    }

    private fun _insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        node ?: return BinaryNode(value)
        if (value < node.value) {
            node.leftChild = _insert(node.leftChild, value) //Chèn bên trái
        } else {
            node.rightChild = _insert(node.rightChild, value) //Chèn bên phải
        }
        return node
    }

    /**
     * Thao tác xóa
     */
    fun remove(value: T) {
        root = _remove(root, value)
    }

    private fun _remove(node: BinaryNode<T>?, value: T): BinaryNode<T>? {
        node ?: return null
        when {
            value == node.value -> {
                if (node.leftChild == null && node.rightChild == null) {
                    return null //Đây là lá
                }
                if (node.leftChild == null) {
                    return node.rightChild //Bên phải
                }
                if (node.rightChild == null) {
                    return node.leftChild //Bên trái
                }
                node.rightChild?.min?.value?.let {
                    node.value = it
                }
                node.rightChild = _remove(node.rightChild, node.value)
            }

            value < node.value -> node.leftChild = _remove(node.leftChild, value)
            else -> node.rightChild = _remove(node.rightChild, value)
        }
        return node
    }

    /**
     * Thao tác tìm kiếm
     */
    fun findElement(value: T): Boolean {
        var currentNode = root
        while (currentNode != null) {
            if (currentNode.value == value) return true

            currentNode = if (currentNode.value < value) {
                currentNode.rightChild
            } else {
                currentNode.leftChild
            }
        }
        return false
    }
}