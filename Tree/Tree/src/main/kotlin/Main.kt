fun main() {
    val tree = TreeNode("Đồ uống")

    val hot = TreeNode("Đồ uống nóng")
    val cold = TreeNode("Đồ uống lạnh")

    val tea = TreeNode("Trà")
    val coffee = TreeNode("Cà phê")
    val chocolate = TreeNode("Ca cao")

    val blackTea = TreeNode("Trà đen")
    val greenTea = TreeNode("Trà xanh")
    val chaiTea = TreeNode("Trà chai")

    val soda = TreeNode("Soda")
    val milk = TreeNode("Sữa")

    val coca = TreeNode("Soda coca")
    val lemon = TreeNode("Soda chanh")

    tree.add(hot, cold)

    hot.add(tea, coffee, chocolate)
    cold.add(soda, milk)

    tea.add(blackTea, greenTea, chaiTea)
    soda.add(coca, lemon)

    println(tree.search("Ca cao")) // Địa chỉ của node
    println(tree.search("Rượu")) // null
}

