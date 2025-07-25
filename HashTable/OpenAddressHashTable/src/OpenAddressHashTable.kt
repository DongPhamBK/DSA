import kotlin.math.abs


//Tạo Hash Table với 16 địa chỉ ô nhớ cơ bản
class OpenAddressHashTable<K, V>(private var capacity: Int = 16) {
    private var size = 0 //Tổng số lượng phần tử hiện tại trong bảng
    private var table: Array<Entry<K, V>?> = Array(capacity) { null } //Table hiện tại

    /**
     * Thêm giá trị vào bảng
     */
    fun put(key: K, value: V) {
        // Nếu hết bộ nhớ, cần mở rộng thêm
        if (size >= capacity) {
            resize(capacity + 1)
        }

        var index = hash(key) //Địa chỉ ô nhớ dành cho key này

        //Chắc chắn bộ nhớ bảng sẽ có ô null do chúng ta đã mở rộng
        while (table[index] != null) {
            if (table[index]?.key == key) {
                table[index]?.value = value //Ghi đè lại value cho key cũ
                return
            }
            index = (index + 1) % capacity // địa chỉ hash mới
        }

        table[index] = Entry(key, value) //Gán vào đây
        size++ // Tăng tổng lượng dữ liệu trong mảng
    }

    /**
     * Xóa phần tử khỏi mảng
     */
    fun remove(key: K): Boolean {
        var index = hash(key)
        while (table[index] != null) {
            if (table[index]?.key == key) {
                table[index] = null //Xóa
                size-- //Cập nhật tổng số phần tử trong bảng

                index = (index + 1) % capacity //Chuyển dịch index
                while (table[index] != null) {
                    val entry = table[index]
                    table[index] = null
                    size--
                    put(entry!!.key, entry.value)
                    index = (index + 1) % capacity //Chuyển dịch index
                }
                return true
            }

            index = (index + 1) % capacity //Tìm tiếp
        }
        return false
    }

    /**
     * Thao tác tìm kiếm
     */
    fun get(key: K): V? {
        var index = hash(key)

        while (table[index] != null) {
            if (table[index]?.key == key) {
                return table[index]?.value
            }
            index = (index + 1) % capacity
        }

        return null
    }

    /**
     * Thuật toán mở rộng bộ nhớ bảng
     */
    private fun resize(newCapacity: Int) {
        val oldTable = table //copy bảng băm cũ
        capacity = newCapacity // Cập nhật dung tích của bảng băm
        size = 0 // Reset lại tổng lượng lưu trữ
        table = Array(newCapacity) { null } //Tạo bảng kích thước mới

        for (entry in oldTable) {
            if (entry != null) {
                put(entry.key, entry.value) //Chèn lại giá trị cũ
            }
        }
    }

    /**
     * Thuật toán hash, trả về địa chỉ ô nhớ
     */
    private fun hash(key: K): Int {
        return abs(key.hashCode()) % capacity
    }

    override fun toString(): String {
        val result = StringBuffer()
        table.forEachIndexed { index, entry ->
            if (entry != null) {
                result.append("Bucket $index: $entry\n")
            } else {
                result.append("Bucket $index: null\n")
            }

        }
        return String(result)
    }
}