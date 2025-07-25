/**
 * @param value: Giá trị lưu trữ của node
 * @param next: Tham chiếu node tiếp theo
 */
data class Node<T : Any>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString() = "$value -> $next"
}