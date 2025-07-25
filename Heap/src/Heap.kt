class Heap {
    private val heap = mutableListOf<Int>() //Danh sách dữ liệu

    fun insert(element: Int) {
        heap.add(element)
        heapifyUp(heap.size - 1)
    }

    fun deleteMax(): Int? {
        if (heap.isEmpty()) return null
        if (heap.size == 1) return heap.removeFirst()
        val root = heap[0]
        heap[0] = heap.removeAt(heap.size - 1)
        heapifyDown(0)
        return root
    }

    fun getMax(): Int? = heap.firstOrNull()

    private fun heapifyUp(index: Int) {
        var childIndex = index
        val element = heap[childIndex]
        var parentIndex = (childIndex - 1) / 2
        while (childIndex > 0 && heap[parentIndex] < element) {
            heap[childIndex] = heap[parentIndex]
            childIndex = parentIndex
            parentIndex = (parentIndex - 1) / 2
        }
    }

    private fun heapifyDown(index: Int) {
        var parentIndex = index
        val element = heap[parentIndex]
        val size = heap.size

        while (true) {
            val leftChildIndex = 2 * parentIndex + 1
            val rightChildIndex = 2 * parentIndex + 2
            var largestIndex = parentIndex

            if (leftChildIndex < size && heap[leftChildIndex] > heap[largestIndex]) {
                largestIndex = leftChildIndex
            }

            if (rightChildIndex < size && heap[rightChildIndex] > heap[largestIndex]) {
                largestIndex = rightChildIndex
            }

            if (largestIndex == parentIndex) break

            heap[parentIndex] = heap[largestIndex]
            parentIndex = largestIndex
        }
        heap[parentIndex] = element
    }

    override fun toString() = heap.joinToString()
}