package com.yourtion.list

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 01/06/2017.
 */

internal class ListTest {

    @Test
    fun insert_next() {
        val list = List()
        val a = list.insert_next("a")
        assertEquals(a.data, "a")
        val b = list.insert_next("b", a)
        assertEquals(b.data, "b")
        assertEquals(list.size, 2)
    }

    @Test
    fun remove_next() {
        val list = List()
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
        val list = List()
        val a = list.insert_next("a")
        assertTrue(list.is_head(a))
    }

    @Test
    fun is_tail() {
        val list = List()
        val a = list.insert_next("a")
        assertTrue(list.is_tail(a))
        val b = list.insert_next("b", a)
        assertTrue(list.is_tail(b))
    }

}
