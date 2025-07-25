fun bubbleSort(arr: Array<Int>) {
    for (i in 0..<arr.size) {
        for (j in 0..<arr.size - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun main() {
    val arr = arrayOf(3, 5, 6, 99, 2, 1, 36, 5523, -1)
    bubbleSort(arr)
    println(arr.contentToString())
    //[-1, 1, 2, 3, 5, 6, 36, 99, 5523]
}