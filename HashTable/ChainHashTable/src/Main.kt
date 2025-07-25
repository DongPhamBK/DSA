fun main() {
    val hashTable = ChainHashTable<String, Int>()
    hashTable.put("Lan", 16)
    hashTable.put("Anh", 26)
    hashTable.put("Hoàng", 28)
    hashTable.put("Chiến", 10)
    println(hashTable.get("Lan")) // 16
    hashTable.remove("Lan")
    println(hashTable.get("Lan")) // null
}
