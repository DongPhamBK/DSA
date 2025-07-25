/**
 * @param value: Giá tri lưu trữ
 * @param priority: Mức độ ưu tiên
 */
data class Node<T>(
    val value: T,
    val priority: Int
) {
    override fun toString() = "$value($priority)"
}