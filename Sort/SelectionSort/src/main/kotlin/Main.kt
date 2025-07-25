fun selectionSort(arr: Array<Int>) {
    for (i in 0..<arr.size - 1) {
        var min = i
        for (j in i + 1..<arr.size) {
            if (arr[j] < arr[min])
                min = j //Vị trí phần tử nhỏ hơn
        }
        val temp = arr[i]
        arr[i] = arr[min]
        arr[min] = temp
    }
}

fun main() {
    val arr = arrayOf(1, 23, 4, 5, 393, -1, 9578)
    selectionSort(arr)
    println(arr.contentToString())
    // [-1, 1, 4, 5, 23, 393, 9578]
}