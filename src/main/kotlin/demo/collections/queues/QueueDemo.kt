package demo.collections.queues

import demo.Demo
import java.util.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class QueueDemo : Demo {

    companion object {
        private const val NAME = "Queues Demo"
    }

    override val name: String = NAME

    override fun execute() {
        println()
        println("Priority queue vs deque")
        println()
        priorityDemo()

        println()
        println("Performance test LinkedList vs ArrayDeque")
        println()
        performanceTest()
    }

    private fun priorityDemo() {

        val priorityQueue: Queue<Int> = PriorityQueue()
        val deque: Queue<Int> = ArrayDeque()

        fillQueues(priorityQueue, deque)

        println("Printing priority queue")
        while (priorityQueue.isNotEmpty()) {
            println(priorityQueue.poll())
        }

        println()
        println("Printing deque")
        while (deque.isNotEmpty()) {
            println(deque.poll())
        }
    }

    private fun performanceTest() {

        val deque: Deque<Int> = ArrayDeque()
        val linkedList: Deque<Int> = LinkedList()

        val size = 20_000_000

        println("Filling queues with $size elements")
        println("ArrayDeque: ${measureTimeMillis { fillQueue(deque, size) }}")
        println("LinkedList: ${measureTimeMillis { fillQueue(linkedList, size) }}")

        println("Polling first 100000 element")
        println("ArrayDeque: ${measureTimeMillis { pollFirstElements(deque, 100_000) }}")
        println("LinkedList: ${measureTimeMillis { pollFirstElements(linkedList, 100_000) }}")

        println("Polling last 100000 element")
        println("ArrayDeque: ${measureTimeMillis { pollLastElements(deque, 1_000_000) }}")
        println("LinkedList: ${measureTimeMillis { pollLastElements(linkedList, 1_000_000) }}")
    }

    private fun pollFirstElements(deque: Deque<Int>, amount: Int) {
        repeat(amount) {
            deque.pollFirst()
        }
    }

    private fun pollLastElements(deque: Deque<Int>, amount: Int) {
        repeat(amount) {
            deque.pollLast()
        }
    }
    private fun fillQueue(queue: Queue<Int>, size: Int) {
        repeat(size) {
            queue.offer(it)
        }
    }

    private fun fillQueues(firstQueue: Queue<Int>, secondQueue: Queue<Int>) {
        repeat(10) {
            val value = Random.nextInt(0, 10)
            firstQueue.offer(value)
            secondQueue.offer(value)
        }
    }

}