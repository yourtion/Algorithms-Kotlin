package com.yourtion.set

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 02/06/2017.
 */
class SetTest {
    @Test
    fun insert() {
        val set = Set()
        assertTrue(set.insert("a"))
        assertTrue(set.insert("b"))
        assertFalse(set.insert("a"))
    }

    @Test
    fun remove() {
        val set = Set()
        set.insert("a")
        set.insert("b")
        set.insert("c")
        assertEquals(set.size, 3)
        assertTrue(set.remove("a"))
        assertFalse(set.remove("d"))
    }

    @Test
    fun is_member() {
        val set = Set()
        set.insert("a")
        assertTrue(set.is_member("a"))
        assertFalse(set.is_member("b"))
    }

    @Test
    fun is_subset() {
        val set1 = Set()
        val set2 = Set()
        assertTrue(set1.is_subset(set2))

        set1.insert("a")
        assertFalse(set1.is_subset(set2))

        set2.insert("a")
        set2.insert("b")
        assertTrue(set1.is_subset(set2))

        set1.insert("c")
        assertFalse(set1.is_subset(set2))
    }

    @Test
    fun is_equal() {
        val set1 = Set()
        val set2 = Set()
        assertTrue(set1.is_equal(set2))

        set1.insert("a")
        assertFalse(set1.is_equal(set2))

        set2.insert("a")
        assertTrue(set1.is_equal(set2))
    }

    @Test
    fun union() {
        val set1 = Set()
        val set2 = Set()
        var set3 = set1.union(set2)
        assertEquals(set3.size, 0)

        set1.insert("a")
        set2.insert("b")
        set3 = set1.union(set2)
        assertEquals(set3.size, 2)
        assertTrue(set3.is_member("a"))
        assertTrue(set3.is_member("b"))

        set2.insert("a")
        set3 = set1.union(set2)
        assertEquals(set3.size, 2)
        assertTrue(set3.is_member("a"))
        assertTrue(set3.is_member("b"))
    }

    @Test
    fun intersection() {
        val set1 = Set()
        val set2 = Set()
        var set3 = set1.intersection(set2)
        assertEquals(set3.size, 0)

        set1.insert("a")
        set2.insert("b")
        set3 = set1.intersection(set2)
        assertEquals(set3.size, 0)

        set2.insert("a")
        set3 = set1.intersection(set2)
        assertEquals(set3.size, 1)
        assertTrue(set3.is_member("a"))
    }

    @Test
    fun difference() {
        val set1 = Set()
        val set2 = Set()
        var set3 = set1.difference(set2)
        assertEquals(set3.size, 0)

        set1.insert("a")
        set2.insert("b")
        set3 = set1.difference(set2)
        assertEquals(set3.size, 1)
        assertTrue(set3.is_member("a"))

        set2.insert("a")
        set2.insert("c")
        set3 = set1.difference(set2)
        assertEquals(set3.size, 0)
    }

}
