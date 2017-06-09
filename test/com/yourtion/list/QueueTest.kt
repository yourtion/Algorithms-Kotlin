package com.yourtion.list

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Created by Yourtion on 08/06/2017.
 */
class QueueTest {
    @Test
    fun enqueue() {
        val queue = Queue()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(queue.size, 3)
    }

    @Test
    fun dequeue() {
        val queue = Queue()
        queue.enqueue(1)
        queue.enqueue(2)
        queue.enqueue(3)
        assertEquals(queue.dequeue(), 1)
        assertEquals(queue.dequeue(), 2)
        assertEquals(queue.dequeue(), 3)
        assertEquals(queue.size, 0)
        assertNull(queue.dequeue())
        assertEquals(queue.size, 0)
    }

    @Test
    fun peek() {
        val queue = Queue()
        assertNull(queue.peek())
        queue.enqueue(1)
        assertEquals(queue.peek(), 1)
        queue.dequeue()
        assertNull(queue.peek())
    }

}