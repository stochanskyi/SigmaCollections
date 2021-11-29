package demo.collections.sets

import demo.Demo
import demo.collections.maps.items.HashedMapItem
import demo.collections.maps.items.MapItem
import demo.collections.maps.items.TreeMapItem
import java.util.*
import kotlin.collections.HashSet

class SetsDemo : Demo {

    companion object {
        private const val NAME = "Sets Demo"
    }

    override val name: String = NAME
    override fun execute() {
        println()
        println("Sets comparison")
        println()
        compareSets()

        println()
        println("Collision demo")
        println()
        collisionDemo()

        println()
        println("TreeSet demo")
        println()
        treeSetDemo()
    }

    private fun compareSets() {
        val hashSet: MutableSet<MapItem> = HashSet<MapItem>().fillSetWithMapItems()
        val linkedHashSet: MutableSet<MapItem> = LinkedHashSet<MapItem>().fillSetWithMapItems()
        val treeSet: MutableSet<MapItem> = TreeSet<MapItem>().fillSetWithMapItems()

        println()
        println("Printing HashSet")
        printSet(hashSet)

        println()
        println("Printing LinkedHashSet")
        printSet(linkedHashSet)

        println()
        println("Printing TreeSet")
        printSet(treeSet)
    }

    private fun collisionDemo() {
        println()
        println("Filling hash set")
        val hashSet: MutableSet<HashedMapItem> = HashSet<HashedMapItem>().fillSetWithHashMapItems()

        println("Making collision in hash map")
        hashSet += HashedMapItem(3)
    }

    private fun treeSetDemo() {
        val treeSet: TreeSet<TreeMapItem> = TreeSet<TreeMapItem>().fillTreeSet()

        println()
        println("Get higher value of 3")
        val higher = treeSet.higher(TreeMapItem(3))
        println(higher?.value ?: "null")

        println()
        println("Get lower entry of 3")
        val lower = treeSet.lower(TreeMapItem(3))
        println(lower?.value ?: "null")
    }

    private fun MutableSet<MapItem>.fillSetWithMapItems(): MutableSet<MapItem> {
        repeat(5) {
            this += MapItem(it)
        }

        return this
    }

    private fun MutableSet<HashedMapItem>.fillSetWithHashMapItems(): MutableSet<HashedMapItem> {
        repeat(5) {
            this += HashedMapItem(it)
        }

        return this
    }

    private fun TreeSet<TreeMapItem>.fillTreeSet(): TreeSet<TreeMapItem> {
        repeat(5) {
            this += TreeMapItem(it)
        }

        return this
    }

    private fun printSet(set: Set<MapItem>) {
        set.forEach { value ->
            println(value.value)
        }
    }
}