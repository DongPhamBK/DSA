class TreeNode<T>(val value: T) {
    //Danh sách các con của node
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    /**
     * Thêm node con
     */
    fun add(child: TreeNode<T>) = children.add(child)

    fun add(vararg child: TreeNode<T>) = children.addAll(child)

    /**
     * Duyệt theo chiều sâu
     */
    fun depthFist(visit: Visitor<T>) {
        visit(this) //Duyệt chính nó
        children.forEach {
            it.depthFist(visit) //đệ quy duyệt các con của nó
        }
    }

    /**
     * Duyệt theo chiều rộng
     */
    fun breadthFist(visit: Visitor<T>) {
        visit(this) //Duyệt chính nó
        val queue = ArrayQueue<TreeNode<T>>() //Queue tự custom
        children.forEach { queue.enqueue(it) } //Thêm node con cùng 1 cấp vào hàng đợi
        var node = queue.dequeue() //Phần tử đầu tiên
        while (node != null) {
            visit(node)//Thăm nó trước
            node.children.forEach { queue.enqueue(it) } //Tiếp tục cho vào hàng đợi
            node = queue.dequeue() //Đến node tiếp theo
        }
    }

    /**
     * Tìm kiếm
     */
    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        depthFist {
            if (it.value == value) result = it
        }
        return result
    }
}

//Định nghĩa duyệt cây
typealias Visitor<T> = (TreeNode<T>) -> Unit