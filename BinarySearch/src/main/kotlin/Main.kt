fun binarySearch(arr: List<Int>, x: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (arr[mid] == x) return mid
        if (arr[mid] < x) {
            left = mid + 1

        }
        if (arr[mid] > x) {
            right = mid - 1
        }
    }
    return -1
}

fun main() {
    val list = listOf(1, 2, 4, 5, 6, 7, 10)
    println(binarySearch(list, 5)) //3
    println(binarySearch(list, 100)) //-1
}