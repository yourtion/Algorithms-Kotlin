package com.yourtion.hash

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 05/06/2017.
 */
class ChainedHashTableTest {
    val hash =  { data: Any -> data.hashCode() }

    @Test
    fun insert() {
        val chtb = ChainedHashTable(5, hash)
        assertTrue(chtb.insert("A"))
        assertEquals(chtb.size, 1)
        assertTrue(chtb.insert("B"))
        assertEquals(chtb.size, 2)
        assertTrue(chtb.insert("F"))
        assertEquals(chtb.size, 3)
        assertFalse(chtb.insert("A"))
        assertEquals(chtb.size, 3)
        assertFalse(chtb.insert("F"))
        assertEquals(chtb.size, 3)
    }

    @Test
    fun remove() {
        val chtb = ChainedHashTable(5, hash)
        assertTrue(chtb.insert("A"))
        assertTrue(chtb.insert("B"))
        assertTrue(chtb.insert("F"))
        assertEquals(chtb.size, 3)
        assertTrue(chtb.remove("A"))
        assertFalse(chtb.remove("A"))
        assertTrue(chtb.remove("B"))
        assertTrue(chtb.remove("F"))
        assertFalse(chtb.remove("F"))
        assertEquals(chtb.size, 0)
    }

    @Test
    fun lookup() {
        val chtb = ChainedHashTable(5, hash)
        assertTrue(chtb.insert("A"))
        assertTrue(chtb.insert("B"))
        assertTrue(chtb.insert("F"))
        assertTrue(chtb.lookup("A"))
        assertTrue(chtb.lookup("F"))
        assertFalse(chtb.lookup("C"))
    }

}