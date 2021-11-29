package demo.tree

import demo.Demo

class TreeDemo : Demo {

    companion object {
        private const val NAME = "Tree Demo"
    }

    override val name: String = NAME

    override fun execute() {
        /*
                    2
                 /     \
               7        5
             /   \        \
           10      6        9
                /   \     /
               5    11   4
         */

        val tree = Tree<Int>()

        val root = tree.addChildLeft(2, null)
        val node1 = tree.addChildLeft(7, root)
        val node2 = tree.addChildRight(5, root)
        val node3 = tree.addChildLeft(10, node1)
        val node4 = tree.addChildRight(6, node1)
        val node5 = tree.addChildRight(9, node2)
        val node6 = tree.addChildLeft(5, node4)
        val node7 = tree.addChildRight(11, node4)
        val node8 = tree.addChildLeft(4, node5)

        println("NLR ${tree.toListNLR().joinToString(", ")}")
        println("LRN ${tree.toListLRN().joinToString(", ")}")
        println("LNR ${tree.toListLNR().joinToString(", ")}")



    }

}