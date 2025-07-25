fun main() {
    val arr = intArrayOf(12, 4, -2, 35, 54, 0, 498)
    mergeSort(arr, 0, arr.size - 1)
    println(arr.contentToString())
    // [-2, 0, 4, 12, 35, 54, 498]
}

//Sắp xếp trộn
fun mergeSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right) return
    val mid = left + (right - left) / 2
    mergeSort(arr, left, mid)
    mergeSort(arr, mid + 1, right)
    merge(arr, left, right)
}


//Thao tác trộn
fun merge(arr: IntArray, left: Int, right: Int) {
    val temp = IntArray(right - left + 1)//Mảng trung gian
    val mid = left + (right - left) / 2
    var i = left
    var j = mid + 1
    var k = 0 //Bộ đếm cho mảng trung gian
    //Bắt đầu trộn
    while (i <= mid && j <= right) {
        if (arr[i] < arr[j]) {
            temp[k] = arr[i]
            k++
            i++
        } else {
            temp[k] = arr[j]
            k++
            j++
        }
    }

    //Các giá trị còn lại
    while (i <= mid) {
        temp[k] = arr[i]
        k++
        i++
    }

    while (j <= right) {
        temp[k] = arr[j]
        k++
        j++
    }

    //Gán lại mảng ban đầu
    for (i in left..right) {
        arr[i] = temp[i - left]
    }
}
 
