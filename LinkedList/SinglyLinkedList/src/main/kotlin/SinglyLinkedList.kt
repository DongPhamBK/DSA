import java.lang.Exception

/**
 * Danh sách liên kết đơn
 *
 */
class SinglyLinkedList<T : Any> {
    private var head: Node<T>? = null //Node đầu tiên
    private var tail: Node<T>? = null //Node cuối cùng
    private var size = 0 //Độ dài hiện tại của danh sách

    /**
     * Độ dài của danh sách
     */
    fun size(): Int = size

    /**
     * Kiểm tra danh sách rỗng hay không
     */
    fun isEmpty(): Boolean = size == 0

    /**
     * Thêm phần tử vào đầu danh sách
     */
    fun push(value: T) {
        val newNode = Node(value) //Tạo 1 nút mới
        newNode.next = head
        head = newNode //gán lại giá trị cho head
        if (tail == null) tail = head // Gán lại tail trùng với head vì chỉ có 1 phần tử
        size++ //Tăng kích thước danh sách
    }

    /**
     * Thêm phần tử vào cuối danh sách
     */
    fun append(value: T) {
        val newNode = Node(value) //Tạo 1 nút mới
        if (isEmpty()) {
            push(value) //Danh sách rỗng thì dùng push
        } else {
            tail!!.next = newNode //tail sẽ trỏ đến node mới này
            tail = newNode //gán lại tail để dùng cho lần sau!
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
        previousNode?.next = newNode //Nút tại vị trí trước index hiện tại sẽ trỏ vào nút mới
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
        size-- //Giảm kích thước danh sách
    }

    /**
     * Đảo ngược danh sách liên kết
     */
    fun reserve(): SinglyLinkedList<T> {
        val reservedSinglyLinkedList = SinglyLinkedList<T>()
        for (i in 0..<size) {
            val node = nodeAt(i)
            reservedSinglyLinkedList.push(node)
        }
        return reservedSinglyLinkedList
    }

    /**
     * Đảo ngược danh sách liên kết
     */
    fun reserve1() {
        val reservedSinglyLinkedList = SinglyLinkedList<T>()
        for (i in 0..<size) {
            val node = nodeAt(i)
            reservedSinglyLinkedList.push(node)
        }

        //Xóa toàn bộ danh sách cũ
        while (!isEmpty()) {
            removeAt(size - 1)
        }

        //Thêm vào dữ liệu của danh sách đảo ngược!
        for (i in 0..<reservedSinglyLinkedList.size) {
            val node = reservedSinglyLinkedList.nodeAt(i)
            append(node)
        }

    }

    /**
     * Đảo ngược danh sách liên kết
     */
    fun reserve2(): SinglyLinkedList<T> {
        val reservedSinglyLinkedList = SinglyLinkedList<T>()
        var currentNode = head
        while (currentNode != null) {
            reservedSinglyLinkedList.push(currentNode.value)
            currentNode = currentNode.next
        }

        return reservedSinglyLinkedList
    }

    override fun toString() = head.toString()
}