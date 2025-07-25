fun main() {
    val hashTable = OpenAddressHashTable<String, Int>()
    hashTable.put("Lan", 16)
    hashTable.put("Anh", 26)
    hashTable.put("Hoàng", 28)
    hashTable.put("Chiến", 10)
    hashTable.remove("Chiến")
    println(hashTable.get("Lan")) //26
    println(hashTable.get("Khuyên")) //null
}