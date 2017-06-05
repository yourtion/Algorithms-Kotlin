package com.yourtion.stack

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

/**
 * Created by Yourtion on 05/06/2017.
 */
class StackTest {
    @Test
    fun push() {
        val stack = Stack()
        stack.push("a")
        assertEquals(stack.size, 1)
        stack.push("b")
        assertEquals(stack.size, 2)
        stack.push("a")
        assertEquals(stack.size, 3)
    }

    @Test
    fun pop() {
        val stack = Stack()
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
        val stack = Stack()
        stack.push("a")
        val a = stack.peek()
        assertEquals(stack.size, 1)
        assertEquals(a, "a")
        stack.pop()
        val n = stack.peek()
        assertNull(n)
    }

}