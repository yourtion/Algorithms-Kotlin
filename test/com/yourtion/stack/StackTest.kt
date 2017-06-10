package com.yourtion.stack

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * StackTest
 * Created by Yourtion on 05/06/2017.
 */
class StackTest {
    @Test
    fun push() {
        val stack = Stack<String>()
        stack.push("a")
        assertEquals(stack.size, 1)
        stack.push("b")
        assertEquals(stack.size, 2)
        stack.push("a")
        assertEquals(stack.size, 3)
    }

    @Test
    fun pop() {
        val stack = Stack<String>()
        stack.push("a")
        stack.push("b")
        stack.push("a")
        val a = stack.pop()
        assertEquals(a, "a")
        val b = stack.pop()
        assertEquals(b, "b")
        val a1 = stack.pop()
        assertEquals(a1, "a")
        val n = stack.pop()
        assertNull(n)
    }

    @Test
    fun peek() {
        val stack = Stack<String>()
        stack.push("a")
        val a = stack.peek()
        assertEquals(stack.size, 1)
        assertEquals(a, "a")
        stack.pop()
        val n = stack.peek()
        assertNull(n)
    }

    @Test
    fun example() {
        val stack = Stack<Int>()

        for (i in IntRange(1, 10).reversed()) {
            stack.insert_next(i)
        }
        stack.print()
        assertEquals(stack.size, 10)

        println("Pushing 100 and 200")
        stack.push(100)
        stack.push(200)
        stack.print()
        assertEquals(stack.size, 12)

        println("Peeking at the top element")
        assertEquals(stack.peek(), 200)

        println("Peeking at an empty stack")
        for (i in IntRange(1, stack.size)) {
            stack.pop()
        }
        stack.print()
        assertNull(stack.peek())
    }

}
