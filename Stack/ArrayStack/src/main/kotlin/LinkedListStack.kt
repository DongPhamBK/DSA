class LinkedListStack<T : Any> {
    private var top: Node<T>? = null //Đỉnh ngăn xếp
    private var size = 0 //Số lượng phần tử hiện tại của ngăn xếp

    /**
     * Thêm phần tử vào ngăn xếp
     * Bản chất là thêm node vào đầu danh sách liên kết
     */
    fun push(value: T) {
        val newNode = Node(value)
        newNode.next = top //Lúc này, node mới sẽ trỏ đến top
        top = newNode //Gán lại top cho node mới
        size++ //Tăng kích thước ngăn xếp
    }

    /**
     * lấy phần tử ra khỏi ngăn xếp
     */
    fun pop(): T? {
        if (isEmpty()) return null
        val topValue = top?.value //Phần tử trên cùng
        top = top?.next //Gán lại giá trị cho top
        size-- //Giảm kích thước ngăn xếp
        return topValue
    }

    /**
     * Kiểm tra phần tử trên đầu ngăn xếp
     */
    fun peek(): T? {
        if (isEmpty()) return null
        return top?.value
    }

    /**
     * Số lượng phần tử hiện có trong ngăn xếp
     */
    fun size() = size

    /**
     * Kiểm tra ngăn xếp rỗng hay không
     */
    fun isEmpty() = size == 0

    override fun toString() = top.toString()
}


