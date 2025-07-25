import kotlin.math.abs

//Tạo Hash table với 16 địa chỉ nhớ cơ bản
class ChainHashTable<K, V>(private val capacity: Int = 16) {
    private val table: Array<MutableList<Entry<K, V>>?> = Array(capacity) { null } //table hiện tại

    /**
     * Hàm put giá trị
     */
    fun put(key: K, value: V) {
        val index = hash(key)
        if (table[index] == null) {
            table[index] = mutableListOf() //Khởi tạo mảng
        }
        val entryList = table[index]!!
        for (i in entryList.indices) {
            if (entryList[i].key == key) {
                entryList[i] = Entry(key, value) //Gán lại giá trị nếu đã có
                return
            }
        }

        //Nếu chưa có giá trị trong entryList, thêm vào danh sách cùng hash
        entryList.add(Entry(key, value))
    }

    /**
     * Thao tác xóa
     */
    fun remove(key: K): Boolean {
        val index = hash(key)
        if (table[index] != null) {
            return table[index]!!.removeIf { it.key == key }
        }
        return false
    }

    /**
     * Thao tác tìm kiếm
     */
    fun get(key: K): V? {
        val index = hash(key)
        if (table[index] != null) {
            return table[index]!!.find { it.key == key }?.value
        }
        return null
    }

    /**
     * Thuật toán hash, trả về địa chỉ ô nhớ
     * hashCode() trả về một giá trị có thể âm, là định dạng của key trong bộ nhớ máy tính
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