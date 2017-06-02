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

}