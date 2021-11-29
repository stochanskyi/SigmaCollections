package demo.tree

class Tree<T> {

    var root: Node<T>? = null

    class Node<T>(
        var value: T,
        var left: Node<T>? = null,
        var right: Node<T>? = null,
    )

    fun addChildLeft(value: T, parent: Node<T>?): Node<T> {
        val node = Node(value)

        if (parent == null) {
            root = node
        } else {
            parent.left = node
        }
        return node
    }

    fun addChildRight(value: T, parent: Node<T>?): Node<T> {
        val node = Node(value)

        if (parent == null) {
            root = node
        } else {
            parent.right = node
        }
        return node
    }

    fun toListNLR(): List<T> {
        return root?.let { toListNLR(it) } ?: emptyList()
    }

    private fun toListNLR(node: Node<T>): List<T> {
        val left = node.left?.let { toListNLR(it) } ?: emptyList()
        val right = node.right?.let { toListNLR(it) } ?: emptyList()

        return listOf(node.value) + left + right
    }

    fun toListLRN(): List<T> {
        return root?.let { toListLRN(it) } ?: emptyList()
    }

    private fun toListLRN(node: Node<T>): List<T> {
        val left = node.left?.let { toListLRN(it) } ?: emptyList()
        val right = node.right?.let { toListLRN(it) } ?: emptyList()

        return left + right + listOf(node.value)
    }

    fun toListLNR(): List<T> {
        return root?.let { toListLNR(it) } ?: emptyList()
    }

    private fun toListLNR(node: Node<T>): List<T> {
        val left = node.left?.let { toListLNR(it) } ?: emptyList()
        val right = node.right?.let { toListLNR(it) } ?: emptyList()

        return left + node.value + right
    }

    fun containsNLR(value: T): Boolean {
        return root?.let { containsNLR(value, it) } ?: false
    }

    private fun containsNLR(value: T, node: Node<T>): Boolean {
        if (value == node.value) return true

        node.left?.let {
            if (containsNLR(value, it)) return true
        }

        node.right?.let {
            if (containsNLR(value, it)) return true
        }

        return false
    }
}