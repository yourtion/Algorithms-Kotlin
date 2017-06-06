package com.yourtion.hash

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 05/06/2017.
 */
class OpenAddressedHashTablesTest {

    val hash1 =  { data: Any -> data.hashCode() }
    val hash2 =  { data: Any -> 1 + data.hashCode() % 7 }

    @Test
    fun insert() {
        val ohtb = OpenAddressedHashTables(11, hash1, hash2)
        assertTrue(ohtb.insert("A"))
        assertEquals(ohtb.size, 1)
        assertTrue(ohtb.insert("B"))
        assertEquals(ohtb.size, 2)
        assertTrue(ohtb.insert("F"))
        assertEquals(ohtb.size, 3)
        assertFalse(ohtb.insert("A"))
        assertEquals(ohtb.size, 3)
        assertFalse(ohtb.insert("F"))
        assertEquals(ohtb.size, 3)
    }

    @Test
    fun remove() {
        val ohtb = OpenAddressedHashTables(11, hash1, hash2)
        assertTrue(ohtb.insert("A"))
        assertTrue(ohtb.insert("B"))
        assertTrue(ohtb.insert("F"))
        assertEquals(ohtb.size, 3)
        assertTrue(ohtb.remove("A"))
        assertFalse(ohtb.remove("A"))
        assertTrue(ohtb.remove("B"))
        assertTrue(ohtb.remove("F"))
        assertFalse(ohtb.remove("F"))
        assertEquals(ohtb.size, 0)
    }

    @Test
    fun lookup() {
        val ohtb = OpenAddressedHashTables(11, hash1, hash2)
        assertTrue(ohtb.insert("A"))
        assertTrue(ohtb.insert("B"))
        assertTrue(ohtb.insert("F"))
        assertTrue(ohtb.lookup("A"))
        assertTrue(ohtb.lookup("F"))
        assertFalse(ohtb.lookup("C"))
    }

}