import demo.Demo
import demo.collections.lists.ListsDemo
import demo.collections.maps.MapsDemo
import demo.collections.queues.QueueDemo
import demo.collections.sets.SetsDemo
import demo.tree.TreeDemo

fun main(args: Array<String>) {
    val demos: List<Demo> = listOf(ListsDemo(), MapsDemo(), SetsDemo(), QueueDemo(), TreeDemo())

    demos.forEach { demo ->
        executeDemo(demo)
    }
}

private fun executeDemo(demo: Demo) {
    println()
    println("----------------------${demo.name}----------------------")
    println()
    demo.execute()
}
