package com.yourtion.set

import org.junit.Assert.*
import org.junit.Test

/**
 * SetTest
 * Created by Yourtion on 02/06/2017.
 */
class SetTest {
    @Test
    fun insert() {
        val set = Set<String>()
        assertTrue(set.insert("a"))
        assertTrue(set.insert("b"))
        assertFalse(set.insert("a"))
    }

    @Test
    fun remove() {
        val set = Set<String>()
        set.insert("a")
        set.insert("b")
        set.insert("c")
        assertEquals(set.size, 3)
        assertTrue(set.remove("a"))
        assertFalse(set.remove("d"))
    }

    @Test
    fun is_member() {
        val set = Set<String>()
        set.insert("a")
        assertTrue(set.is_member("a"))
        assertFalse(set.is_member("b"))
    }

    @Test
    fun is_subset() {
        val set1 = Set<String>()
        val set2 = Set<String>()
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
        val set1 = Set<String>()
        val set2 = Set<String>()
        assertTrue(set1.is_equal(set2))

        set1.insert("a")
        assertFalse(set1.is_equal(set2))

        set2.insert("a")
        assertTrue(set1.is_equal(set2))
    }

    @Test
    fun union() {
        val set1 = Set<String>()
        val set2 = Set<String>()
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
        val set1 = Set<String>()
        val set2 = Set<String>()
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
        val set1 = Set<String>()
        val set2 = Set<String>()
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

    @Test
    fun example() {
        val set = Set<Int>()

        for (i in IntRange(1, 10).reversed()) {
            set.insert(i)
        }
        set.print()
        assertEquals(set.size, 10)

        println("Inserting the same members again")
        for (i in IntRange(1, 10).reversed()) {
            set.insert(i)
        }
        set.print()
        assertEquals(set.size, 10)

        println("Inserting 200 and 100")
        set.insert(200)
        set.insert(100)
        set.print()
        assertEquals(set.size, 12)

        println("Removing 100, 5, and 10")
        set.remove(100)
        set.remove(5)
        set.remove(10)
        set.print()
        assertEquals(set.size, 9)

        val set1 = Set<Int>()
        val set2 = Set<Int>()

        for (i in IntRange(1, 10).reversed()) {
            set1.insert(i)
            if (i == 5 || i == 6 || i == 7) {
                set2.insert(i * 10)
            } else if (i == 3 || i == 1) {
                set2.insert(i)
            }
        }
        set1.print()
        assertEquals(set1.size, 10)
        set2.print()
        assertEquals(set2.size, 5)

        println("Determining the union of the two sets")
        val setu = set1.union(set2)
        setu.print()
        assertEquals(setu.size, 13)
        assertTrue(setu.is_member(50))
        assertTrue(setu.is_member(1))
        assertTrue(setu.is_member(4))

        println("Determining the intersection of the two sets")
        val seti = set1.intersection(set2)
        seti.print()
        assertEquals(seti.size, 2)
        assertTrue(seti.is_member(1))
        assertTrue(seti.is_member(3))

        println("Determining the difference of the two sets")
        val setd = set1.difference(set2)
        setd.print()
        assertEquals(setd.size, 8)
        assertTrue(setd.is_member(2))
        assertTrue(setd.is_member(6))
        assertTrue(setd.is_member(10))

        println("Testing whether the intersection equals Set 1")
        assertFalse(seti.is_equal(set1))

        println("Testing whether Set 1 equals itself")
        assertTrue(set1.is_equal(set1))

        println("Testing whether the intersection is a subset of Set 1")
        assertTrue(seti.is_subset(set1))

        println("Testing whether Set 2 is a subset of Set 1")
        assertFalse(set2.is_subset(set1))
    }

}
