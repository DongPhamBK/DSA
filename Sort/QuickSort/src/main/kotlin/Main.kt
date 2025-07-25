fun quickSort(arr: IntArray, left: Int, right: Int) {
    if (left < right) {
        var index = right + (left - right) / 2 //Chọn mid làm trục chính
        index = partition(arr, left, right, index) //Phân vùng
        if (left < index) {
            quickSort(arr, left, index - 1) //Sắp xếp bên trái
        }
        if (index < right) {
            quickSort(arr, index + 1, right) //Sắp xếp bên phải
        }
    }
}

fun partition(arr: IntArray, left: Int, right: Int, index: Int): Int {
    val pivot = arr[index] //Chọn trục chính
    //Đổi chỗ
    var temp = arr[index]
    arr[index] = arr[right]
    arr[right] = temp

    var storeIndex = left
    for (i in left..<right) {
        if (arr[i] < pivot) {
            //Đổi chỗ
            temp = arr[storeIndex]
            arr[storeIndex] = arr[i]
            arr[i] = temp

            storeIndex++
        }
    }

    temp = arr[storeIndex]
    arr[storeIndex] = arr[right]
    arr[right] = temp

    return storeIndex
}

fun main() {
    val arr = intArrayOf(1, -1, 35, 0, 394, 2309)
    quickSort(arr, 0, arr.size - 1)
    println(arr.contentToString())
    // [-1, 0, 1, 35, 394, 2309]
}
