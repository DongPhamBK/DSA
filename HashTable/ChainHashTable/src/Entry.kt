/**
 * Entry là bộ key-value chúng ta cần lưu trữ
 */
data class Entry<K, V>(
    val key: K,
    var value: V
) {
    override fun toString() = "$key - $value"
}
