package com.yourtion.list

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 01/06/2017.
 */
class CListTest {
    @Test
    fun insert_next() {
        val list = CList()
        val a = list.insert_next("a")
        assertEquals(a!!.data, "a")
        val b = list.insert_next("b", a)
        assertEquals(b!!.data, "b")
        assertEquals(list.size, 2)
    }

    @Test
    fun remove_next() {
        val list = CList()
        val a = list.insert_next("a")
        val b = list.insert_next("b", a)
        val aa = list.remove_next(b!!)
        assertEquals(aa!!.data, "a")
        val ab = list.remove_next(list.head!!)
        assertEquals(ab!!.data, "b")
        assertEquals(list.size, 0)
        val ad = list.remove_next(a!!)
        assertNull(ad)
    }

    @Test
    fun is_head() {
        val list = CList()
        val a = list.insert_next("a")
        assertTrue(list.is_head(a!!))
    }

    fun CList.print() {
        if (size == 0) return println("-> CList is Empty")
        var str = "-> List size: $size \n-"
        var i = size
        var element = head
        while (i > 0) {
            str += "-> [" + element!!.data.toString() + "] "
            element = element.next
            i--
        }
        str += "\n"
        print(str)
    }

    @Test
    fun example() {
        val list = CList()
        var element = list.head

        for (i in IntRange(1, 10)) {
            element = list.insert_next(i, element)
        }
        list.print()
        assertEquals(list.size, 10)

        element = list.head
        for (i in IntRange(1, 10)) {
            element = element!!.next
        }
        println("Removing an element after the one containing " + element!!.data)
        assertEquals(element.data, 1)
        element = list.remove_next(element)
        list.print()
        assertEquals(element!!.data, 2)


        element = list.head
        for (i in IntRange(1, 15)) {
            element = element!!.next
        }
        println("Circling and inserting 11 after the element containing " + element!!.data)
        assertEquals(element.data, 8)
        element = list.insert_next(11, element)
        list.print()
        assertEquals(element!!.data, 11)

    }

}
