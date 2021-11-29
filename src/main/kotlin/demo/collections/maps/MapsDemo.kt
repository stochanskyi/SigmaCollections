package demo.collections.maps

import demo.Demo
import demo.collections.maps.items.HashedMapItem
import demo.collections.maps.items.MapItem
import demo.collections.maps.items.TreeMapItem
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class MapsDemo : Demo {

    companion object {
        private const val NAME = "Maps Demo"
    }

    override val name: String = NAME

    override fun execute() {
        println()
        println("Maps comparison")
        println()
        compareMaps()

        println()
        println("Collision demo")
        println()
        collisionDemo()

        println()
        println("TreeMap demo")
        println()
        treeMapDemo()
    }

    private fun compareMaps() {
        val hashMap: MutableMap<MapItem, Int> = HashMap<MapItem, Int>().fillMapWithMapItems()
        val linkedHashMap: MutableMap<MapItem, Int> = LinkedHashMap<MapItem, Int>().fillMapWithMapItems()
        val treeMap: MutableMap<MapItem, Int> = TreeMap<MapItem, Int>().fillMapWithMapItems()

        println()
        println("Printing HashMap")
        printMap(hashMap)

        println()
        println("Printing LinkedHashMap")
        printMap(linkedHashMap)

        println()
        println("Printing TreeMap")
        printMap(treeMap)
    }

    private fun collisionDemo() {
        println()
        println("Filling hash map")
        val hashMap: MutableMap<HashedMapItem, Int> = HashMap<HashedMapItem, Int>().fillMapWithHashMapItems()

        println("Making collision in hash map")
        hashMap[HashedMapItem(3)] = 33
    }

    private fun treeMapDemo() {
        val treeMap: TreeMap<TreeMapItem, Int> = TreeMap<TreeMapItem, Int>().fillTreeMap()

        println()
        println("Get higher entry of 3")

        var entry = treeMap.higherEntry(TreeMapItem(3))
        println("key: ${entry.key.value} value: ${entry.value}")

        println()
        println("Get lower entry of 3")
        entry = treeMap.lowerEntry(TreeMapItem(3))
        println("key: ${entry.key.value} value: ${entry.value}")
    }

    private fun MutableMap<MapItem, Int>.fillMapWithMapItems(): MutableMap<MapItem, Int> {
        repeat(5) {
            this[MapItem(it)] = it
        }

        return this
    }

    private fun MutableMap<HashedMapItem, Int>.fillMapWithHashMapItems(): MutableMap<HashedMapItem, Int> {
        repeat(5) {
            this[HashedMapItem(it)] = it
        }

        return this
    }

    private fun TreeMap<TreeMapItem, Int>.fillTreeMap(): TreeMap<TreeMapItem, Int> {
        repeat(5) {
            this[TreeMapItem(it)] = it
        }

        return this
    }

    private fun printMap(map: Map<MapItem, Int>) {
        map.forEach { (key, _) ->
            println("Key: ${key.value}")
        }
    }
}