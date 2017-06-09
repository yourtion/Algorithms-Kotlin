package com.yourtion.hash

import org.junit.Assert.*
import org.junit.Test

/**
 * ChainedHashTableTest
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

    fun ChainedHashTable.print() {
        if (size == 0) return println("-> ChainedHashTable is Empty")
        var str = "-> ChainedHashTable size: $size \n"
        for (i in IntRange(0, buckets - 1)) {
            val bucket = table[i]
            var element = bucket.head
            str += "--> Bucket[$i] = "
            while (element != null) {
                str += element.data.toString() + " "
                element = element.next
            }
            str += "\n"
        }
        print(str)
    }

    @Test
    fun example() {
        val alphabet1 = Array(26, { (it + 97).toChar().toString() })

        val chtb = ChainedHashTable(11, hash)

        for (c in alphabet1) {
            chtb.insert(c)
            chtb.insert(c.toUpperCase())
        }
        chtb.print()

        println("Trying to insert d again...")
        assertFalse(chtb.insert("D"))

        println("Trying to insert G again...")
        assertFalse(chtb.insert("G"))

        println("Removing d, G, and S")
        assertTrue(chtb.remove("d"))
        assertTrue(chtb.remove("G"))
        assertTrue(chtb.remove("S"))
        chtb.print()

        println("Trying to insert d again...")
        assertTrue(chtb.insert("d"))
        println("Trying to insert G again...")
        assertTrue(chtb.insert("G"))
        chtb.print()

        println("Lookup D ...")
        assertTrue(chtb.lookup("D"))
        println("Lookup S ...")
        assertFalse(chtb.lookup("S"))
        println("Lookup A ...")
        assertTrue(chtb.lookup("A"))
    }
}
