class ArrayStack<T : Any> {
    private val storage: ArrayList<T> = arrayListOf() //Bộ lưu trữ, stack không giới hạn kích thước

    /**
     * Thao tác thêm phần tử vào ngăn xếp
     */
    fun push(value: T) {
        storage.add(value)
    }

    /**
     * Thao tác kiểm tra phần tử trên cùng của ngăn xếp
     */
    fun peek(): T? {
        if (isEmpty()) return null
        return storage[storage.size - 1]
    }

    /**
     * Thao tác lấy phần tử khỏi ngăn xếp
     */
    fun pop(): T? {
        if (isEmpty()) return null
        return storage.removeAt(storage.size - 1)
    }

    /**
     * Kích thước ngăn xếp
     */
    fun size() = storage.size

    /**
     * Kiểm tra ngăn xếp rỗng hay không
     */
    fun isEmpty() = storage.isEmpty()


    override fun toString() = storage.asReversed().joinToString(separator = "") { "$it|" }
}