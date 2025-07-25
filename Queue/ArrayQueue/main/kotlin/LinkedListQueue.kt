class LinkedListQueue<T : Any> {
    private var head: Node<T>? = null //Đầu hàng đợi, nơi trả dữ liệu
    private var tail: Node<T>? = null //Đuôi hàng đợi, nơi nạp dữ liệu
    private var size = 0 //Số lượng phần tử hiện có trong hàng đợi


    /**
     * Thêm vào hàng đợi
     */
    fun enqueue(value: T) {
        val newNode = Node(value)
        if (isEmpty()) {
            head = newNode
            tail = newNode //Chỉ có 1 phần tử, nên tail trùng head
        } else {
            tail?.next = newNode
            tail = newNode //Gán lại đuôi bằng node mới
        }
        size++ //Tăng số lượng phần tử
    }

    /**
     * Xóa khỏi hàng đợi
     */
    fun dequeue(): T? {
        if (isEmpty()) return null
        val headValue = head?.value
        head = head?.next
        size-- //Giảm số lượng phần tử
        return headValue
    }

    /**
     * Kiểm tra phần tử đầu hàng đợi
     */
    fun peek(): T? {
        if (isEmpty()) return null
        return head?.value
    }

    /**
     * Kiểm tra số lượng phần tử
     */
    fun size() = size


    /**
     * Kiểm tra hàng đợi rỗng hay không
     */
    fun isEmpty() = size == 0


    override fun toString() = head.toString()
}