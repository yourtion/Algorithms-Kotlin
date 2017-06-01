package com.yourtion.list

import org.junit.Assert.*
import org.junit.Test

/**
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


}