class ArrayQueue<T : Any> {
    private val storage: ArrayList<T> = arrayListOf() //Bộ lưu trữ, queue không giới hạn

    /**
     * Thêm vào hàng đợi
     */
    fun enqueue(value: T) {
        storage.add(value)
    }

    /**
     * Xóa khỏi hàng đợi
     */
    fun dequeue(): T? {
        if (isEmpty()) return null
        return storage.removeFirst()
    }

    /**
     * Kiểm tra phần tử đầu hàng đợi
     */
    fun peek(): T? {
        if (isEmpty()) return null
        return storage.first()
    }

    /**
     * Kiểm tra số lượng phần tử
     */
    fun size() = storage.size

    /**
     * Kiểm tra hàng đợi rỗng hay không
     */
    fun isEmpty() = storage.isEmpty()
    override fun toString() = storage.joinToString("<=",  "<=", "<=")
}