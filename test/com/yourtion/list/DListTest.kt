package com.yourtion.list

import org.junit.Assert.*
import org.junit.Test

/**
 * DListTest
 * Created by Yourtion on 01/06/2017.
 */
class DListTest {
    @Test
    fun insert_next() {
        val list = DList()
        val a = list.insert_next("a")
        assertEquals(a!!.data, "a")
        val a1 = list.insert_next("a")
        assertNull(a1)
        val b = list.insert_next("b", a)
        assertEquals(b!!.data, "b")
        assertEquals(list.size, 2)
    }

    @Test
    fun insert_prev() {
        val list = DList()
        val a = list.insert_prev("a")
        assertEquals(a!!.data, "a")
        val a1 = list.insert_prev("a")
        assertNull(a1)
        val b = list.insert_prev("b", a)
        assertEquals(b!!.data, "b")
        assertEquals(list.size, 2)
    }

    @Test
    fun remove() {
        val list = DList()
        val a = list.insert_next("a")
        val b = list.insert_next("b", a)
        val c = list.insert_next("c", b)
        val ac = list.remove(c!!)
        assertEquals(ac!!.data, "c")
        val aa = list.remove(a!!)
        assertEquals(aa!!.data, "a")
        val ab = list.remove(b!!)
        assertEquals(ab!!.data, "b")
        assertEquals(list.size, 0)
    }

    @Test
    fun is_head() {
        val list = DList()
        val a = list.insert_next("a")
        assertTrue(list.is_head(a!!))
    }

    @Test
    fun is_tail() {
        val list = DList()
        val a = list.insert_next("a")
        assertTrue(list.is_tail(a!!))
        val b = list.insert_next("b", a)
        assertTrue(list.is_tail(b!!))
    }

    fun DList.print() {
        if (size == 0) return println("-> DList is Empty")
        var str = "-> DList size: $size \n-"
        var element = head
        while (element != null) {
            str += "-> [" + element.data.toString() + "] "
            element = element.next
        }
        str += "\n"
        print(str)
    }

    @Test
    fun example() {
        val list = DList()

        for (i in IntRange(1, 10).reversed()) {
            list.insert_next(i, list.head)
        }
        list.print()
        assertEquals(list.size, 10)

        var element = list.head
        for (i in IntRange(0, 8)) {
            element = element!!.next
        }
        println("Removing an element after the one containing " + element!!.data)
        assertEquals(element.data, 9)
        element = list.remove(element)
        list.print()
        assertEquals(element!!.data, 9)

        println("Inserting 11 at the tail of the list")
        list.insert_next(11, list.tail)
        list.print()
        assertEquals(list.tail!!.data, 11)

        println("Removing an element at the tail of the list")
        element = list.remove(list.tail!!)
        list.print()
        assertEquals(element!!.data, 11)

        println("Inserting 12 just before the tail of the list")
        list.insert_prev(12, list.tail!!)
        list.print()
        assertEquals(list.tail!!.data, 8)
        assertEquals(list.size, 10)

        println("Iterating and removing the fourth element")
        element = list.head
        element = element!!.next
        element = element!!.prev
        element = element!!.next
        element = element!!.prev
        element = element!!.next
        element = element!!.next
        element = element!!.next
        element = element!!.next
        element = list.remove(element!!)
        list.print()
        assertEquals(element!!.data, 4)

        println("Inserting 13 before the first element")
        list.insert_prev(13, list.head)
        list.print()
        assertEquals(list.head!!.data, 13)

        println("Removing an element at the head of the list")
        element = list.remove(list.head!!)
        list.print()
        assertEquals(element!!.data, 13)
        assertEquals(list.head!!.data, 10)

        println("Inserting 14 just after the head of the list")
        list.insert_next(14, list.head)
        list.print()
        assertEquals(list.size, 10)

        println("Inserting 015 two elements after the head of the list")
        element = list.head
        element = element!!.next
        list.insert_next(15, element)
        list.print()
        assertEquals(list.size, 11)

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
