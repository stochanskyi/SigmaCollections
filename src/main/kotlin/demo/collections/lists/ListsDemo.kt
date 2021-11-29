package demo.collections.lists

import demo.Demo
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.measureTimeMillis

class ListsDemo : Demo {

    companion object {
        private const val NAME = "Lists Demo"
    }

    override val name: String = NAME

    override fun execute() {
        val size = 20000000

        val arrayList = ArrayList<Int>()

        val linkedList = LinkedList<Int>()

        println()
        println("filling with $size items")
        printWithTime("ArrayList") { fillCollection(arrayList, size) }
        printWithTime("LinkedList") { fillCollection(linkedList, size) }

        println()
        println("Adding at first position")
        printWithTime("ArrayList") { arrayList.add(0, 200001) }
        printWithTime("LinkedList") { linkedList.add(0, 200001) }

        println()
        println("Adding to end")
        printWithTime("ArrayList") { arrayList.add(arrayList.lastIndex, 200001) }
        printWithTime("LinkedList") { linkedList.add(linkedList.lastIndex, 200001) }

        println()
        println("Getting from middle")
        printWithTime("ArrayList") { arrayList[20_000_000 / 2] }
        printWithTime("LinkedList") { linkedList[20_000_000 / 2] }

        println()
        println("Converting to array")
        printWithTime("ArrayList") { arrayList.toArray() }
        printWithTime("LinkedList") { linkedList.toArray() }

        println()
        println("Sorting")
        printWithTime("ArrayList") { arrayList.sort() }
        printWithTime("LinkedList") { linkedList.sort() }
    }

    private fun printWithTime(title: String, action: () -> Unit) {
        val executionTime = measureTimeMillis { action() }
        println("$title: $executionTime")

    }

    private fun fillCollection(collection: MutableCollection<Int>, size: Int) {
        repeat(size) {
            collection.add(it)
        }
    }
}