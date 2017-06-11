package com.yourtion.list

import org.junit.Assert.*
import org.junit.Test

/**
 * ListTest
 * Created by Yourtion on 01/06/2017.
 */

internal class ListTest {

    @Test
    fun insert_next() {
        val list = List<String>()
        val a = list.insert_next("a")
        assertEquals(a.data, "a")
        val b = list.insert_next("b", a)
        assertEquals(b.data, "b")
        assertEquals(list.size, 2)
    }

    @Test
    fun remove_next() {
        val list = List<String>()
        val a = list.insert_next("a")
        val b = list.insert_next("b", a)
        list.insert_next("c", b)
        val aa = list.remove_next()
        assertEquals(aa!!.data, "a")
        val ab = list.remove_next(b)
        assertEquals(ab!!.data, "c")
        assertEquals(list.size, 1)
        val ac = list.remove_next()
        assertEquals(ac!!.data, "b")
        val ad = list.remove_next()
        assertNull(ad)
    }

    @Test
    fun is_head() {
        val list = List<String>()
        val a = list.insert_next("a")
        assertTrue(list.is_head(a))
    }

    @Test
    fun is_tail() {
        val list = List<String>()
        val a = list.insert_next("a")
        assertTrue(list.is_tail(a))
        val b = list.insert_next("b", a)
        assertTrue(list.is_tail(b))
    }

    @Test
    fun iterator() {
        val list = List<Int>()
        for (i in IntRange(1, 10).reversed()) {
            list.insert_next(i)
        }
        for ((index, data) in list.withIndex()) {
            assertEquals(index + 1, data)
        }
        list.forEachIndexed({ index, data -> assertEquals(index + 1, data) })
    }

    @Test
    fun example() {
        val list = List<Int>()

        for (i in IntRange(1, 10).reversed()) {
            list.insert_next(i)
        }
        list.print()
        assertEquals(list.size, 10)

        var element = list.head
        for (i in IntRange(0, 6)) {
            element = element!!.next
        }
        println("Removing an element after the one containing " + element!!.data)
        assertEquals(element.data, 8)
        element = list.remove_next(element)
        list.print()
        assertEquals(element!!.data, 9)

        println("Inserting 11 at the tail of the list")
        list.insert_next(11, list.tail)
        list.print()
        assertEquals(list.tail!!.data, 11)

        println("Removing an element after the first element")
        element = list.remove_next(list.head)
        list.print()
        assertEquals(element!!.data, 2)

        println("Inserting 12 at the head of the list")
        list.insert_next(12)
        list.print()
        assertEquals(list.head!!.data, 12)

        println("Iterating and removing the fourth element")
        element = list.head
        element = element!!.next
        element = element!!.next
        element = list.remove_next(element)
        list.print()
        assertEquals(element!!.data, 4)

        println("Inserting 13 after the first element")
        list.insert_next(13, list.head)
        list.print()
        assertEquals(list.size, 10)

        var i = list.is_head(list.head!!)
        println("Testing is_head...Value=$i (true=OK)")
        assertTrue(i)

        i = list.is_head(list.tail!!)
        println("Testing is_head...Value=$i (false=OK)")
        assertFalse(i)

        i = list.is_tail(list.tail!!)
        println("Testing is_tail...Value=$i (true=OK)")
        assertTrue(i)

        i = list.is_tail(list.head!!)
        println("Testing is_tail...Value=$i (false=OK)")
        assertFalse(i)

    }

}
