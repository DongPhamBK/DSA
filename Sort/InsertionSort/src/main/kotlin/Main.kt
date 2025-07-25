fun insertionSort(arr: Array<Int>) {
    for (i in 1..<arr.size) {
        //Duyệt từ phần tử thứ 2
        val last = arr[i] //Phần tử đang cần sắp xếp
        var j = i - 1 //Vị trí phần tử trước phần tử đang sắp xếp
        while (j >= 0 && arr[j] > last) {
            //Nếu sai thứ tự, cứ chuyển dịch dần
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = last //Gán đúng vị trí
    }
}

fun main() {
    val arr = arrayOf(1, 3, 7, 5, -1, 456, 1920)
    insertionSort(arr)
    println(arr.contentToString())
    // [-1, 1, 3, 5, 7, 456, 1920]
}