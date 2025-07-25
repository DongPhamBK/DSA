class DoublyLinkedList<T : Any> {
    private var head: Node<T>? = null // Node đầu tiên
    private var tail: Node<T>? = null //Node cuối cùng
    private var size = 0//Kích thước danh sách

    /**
     * Thao tác thêm vào đầu danh sách
     */
    fun push(value: T) {
        val newNode = Node(value)
        head?.prev = newNode // Phía trước là node mới
        newNode.next = head //Phía sau node mới là head cũ
        head = newNode //Gán lại head
        if (tail == null) tail = head //Hợp nhất con 2 đầu
        size++ //Tăng kích thước danh sách
    }

    /**
     * Thao tác thêm vào đuôi danh sách
     */
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
        } else {
            val newNode = Node(value)
            tail?.next = newNode //Phía sau là node mới
            newNode.prev = tail //Phía trước node mới là tail cũ
            tail = newNode //Gán lại tail
            size++ //Tăng kích thước danh sách
        }

    }

    /**
     * Đọc giá trị của node tại vị trí bất kỳ,
     * index bắt đầu từ 0
     */
    fun nodeAt(index: Int): T {
        if (index < 0 || index > size - 1) {
            throw Exception("Out of index in 0..${size - 1}")
        }

        //Duyệt từ node ban đầu
        var currentNode = head!!
        var currentIndex = 0
        while (currentIndex < index) {
            currentNode = currentNode.next!!
            currentIndex++
        }

        return currentNode.value
    }

    /**
     * Chèn node tại vị trí index
     * Index có thể bằng 0 hoặc ngay sau node cuối cùng, vị trí size
     */
    fun insert(value: T, index: Int) {
        if (index < 0 || index > size) {
            throw Exception("Out of index in 0..$size")
        }

        if (index == 0) {
            push(value)
            return
        } //Trường hợp đặc biệt

        //Tìm node trước vị trí cần chèn
        var previousNode = head
        var currentIndex = 0
        while (currentIndex < index - 1) {
            previousNode = previousNode?.next
            currentIndex++
        }

        //Chèn vào sau previousNode
        val newNode = Node(value)
        newNode.next = previousNode?.next //Đầu tiên, trỏ nút mới sang nút tiếp theo
        newNode.prev = previousNode //Trỏ ngược lại
        previousNode?.next = newNode //Nút tại vị trí trước index hiện tại sẽ trỏ vào nút mới
        newNode.next?.prev = newNode //Hoàn tất ghép nối
        size++ //Tăng kích thước danh sách
    }

    /**
     * Xóa node tại vị trí index
     */
    fun removeAt(index: Int) {
        if (index < 0 || index > size - 1) {
            throw Exception("Out of index in 0..${size - 1}")
        }
        if (index == 0) {
            head = head?.next //Trường hợp đặc biệt
            head?.prev = null
            size-- //Giảm kích thước danh sách
            return
        }

        //Tìm node trước vị trí cần xóa
        var previousNode = head
        var currentIndex = 0
        while (currentIndex < index - 1) {
            previousNode = previousNode?.next
            currentIndex++
        }

        val deletedNode = previousNode?.next
        previousNode?.next = deletedNode?.next
        deletedNode?.next?.prev = previousNode
        size-- //Giảm kích thước danh sách
    }

    /**
     * Độ dài của danh sách
     */
    fun size(): Int = size

    /**
     * Kiểm tra danh sách rỗng hay không
     */
    fun isEmpty(): Boolean = size == 0

    override fun toString(): String {
        val linkedListString = StringBuilder()
        var currentNode = head
        while (currentNode != null) {
            linkedListString.append(" <-> (${currentNode.prev}) $currentNode (${currentNode.next})")
            currentNode = currentNode.next
        }
        return if (linkedListString.isEmpty()) "null" else linkedListString.toString()
    }
}