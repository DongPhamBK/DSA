/**
 * @param value: Giá trị lưu trữ của node
 * @param prev: Tham chiếu node trước đó
 * @param next: Tham chiếu node tiếp theo
 */
data class Node<T : Any>(
    var value: T,
    var prev: Node<T>? = null,
    var next: Node<T>? = null
) {
    override fun toString() = value.toString()
}