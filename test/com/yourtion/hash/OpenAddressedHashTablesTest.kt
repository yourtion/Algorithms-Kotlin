package com.yourtion.hash

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 05/06/2017.
 */
class OpenAddressedHashTablesTest {

    val hash1 = { data: Any -> data.hashCode() }
    val hash2 = { data: Any -> 1 + data.hashCode() % 7 }

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

    @Test
    fun badHashFunction() {
        val ohtb = OpenAddressedHashTables(11, hash1, hash1)
        assertTrue(ohtb.insert("B"))
        assertTrue(ohtb.insert("C"))
        assertTrue(ohtb.insert("D"))
        assertTrue(ohtb.insert("E"))
        assertTrue(ohtb.insert("F"))
        assertFalse(ohtb.insert("c"))
    }

    fun OpenAddressedHashTables.print() {
        if (size == 0) return println("-> ChainedHashTable is Empty")
        var str = "-> ChainedHashTable size: $size \n"
        for (i in IntRange(0, positions - 1)) {
            val slot = table[i]
            if (slot != null && slot != vacated) {
                str += "--> Slot[$i] = $slot"
            } else {
                str += "--> Slot[$i] = "
            }
            str += "\n"
        }
        print(str)
    }

    @Test
    fun example() {
        val ohtb = OpenAddressedHashTables(11, hash1, hash2)
        assertTrue(ohtb.insert("B"))
        assertTrue(ohtb.insert("C"))
        assertTrue(ohtb.insert("D"))
        assertTrue(ohtb.insert("E"))
        assertTrue(ohtb.insert("F"))
        ohtb.print()
        assertEquals(ohtb.size, 5)

        println("Hash collision")
        assertTrue(ohtb.insert("c"))
        assertTrue(ohtb.insert("d"))
        assertTrue(ohtb.insert("e"))
        assertTrue(ohtb.insert("f"))
        assertTrue(ohtb.insert("g"))
        ohtb.print()
        assertEquals(ohtb.size, 10)


        println("Trying to insert E again...")
        assertFalse(ohtb.insert("E"))
        println("Trying to insert C again...")
        assertFalse(ohtb.insert("C"))
        println("Trying to insert g again...")
        assertFalse(ohtb.insert("g"))

        println("Removing C, E, and g")
        assertTrue(ohtb.remove("C"))
        assertTrue(ohtb.remove("E"))
        assertTrue(ohtb.remove("g"))
        ohtb.print()
        assertEquals(ohtb.size, 7)

        println("Trying to insert C again...")
        assertTrue(ohtb.insert("C"))
        println("Trying to insert E again...")
        assertTrue(ohtb.insert("E"))
        println("Trying to insert g again...")
        assertTrue(ohtb.insert("g"))

        println("Inserting X")
        assertTrue(ohtb.insert("X"))
        ohtb.print()
        assertEquals(ohtb.size, 11)

        println("Trying to insert into a full table")
        assertFalse(ohtb.insert("Y"))

        println("Lookup X ...")
        assertTrue(ohtb.lookup("X"))
        assertFalse(ohtb.lookup("K"))
        assertFalse(ohtb.remove("K"))
        println("Lookup Z ...")
        assertFalse(ohtb.lookup("Z"))
        println("Lookup e ...")
        assertTrue(ohtb.lookup("e"))
    }

}
