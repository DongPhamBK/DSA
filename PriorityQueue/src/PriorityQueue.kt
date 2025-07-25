import kotlin.math.cbrt

class PriorityQueue<T> {
    private val priorityQueue: MutableList<Node<T>> = mutableListOf() //Danh sách dữ liệu

    /**
     * Kiểm tra số lượng phần tử
     */
    fun size() = priorityQueue.size

    /**
     * Kiểm tra hàng đợi rỗng hay không
     */
    fun isEmpty() = priorityQueue.isEmpty()

    /**
     * Thao tác thêm phần tử
     */
    fun enqueue(value: T, priority: Int) {
        val newNode = Node(value, priority)
        //Tìm vị trí đầu tiên có độ ưu tiên phù hợp
        val index = priorityQueue.indexOfFirst { it.priority > newNode.priority }
        // Nếu không có node nào ưu tiên cao hơn, thêm vào sau cùng
        if (index != -1) {
            priorityQueue.add(index, newNode)
        } else {
            priorityQueue.add(newNode)
        }
    }

    /**
     * Thao tác xóa phần tử
     */
    fun dequeue(): Node<T>? {
        if (priorityQueue.isEmpty()) return null
        return priorityQueue.removeFirst()
    }

    override fun toString() = priorityQueue.joinToString()
}