package com.yourtion.heap

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * HeapTest
 * Created by Yourtion on 07/06/2017.
 */
class HeapTest {

    val compare_int = { data1: Any, data2: Any -> data1 as Int - data2 as Int }

    @Test
    fun insert() {
        val heap = Heap(compare_int)
        for (i in IntRange(0, 9)) {
            heap.insert(i)
            assertEquals(heap.size, i + 1)
        }
        for (i in IntRange(0, 9).reversed()) {
            heap.insert(i * 10)
            assertEquals(heap.size, 20 - i)
        }
    }

    @Test
    fun extract() {
        val heap = Heap(compare_int)
        for (i in IntRange(0, 9)) {
            heap.insert(i)
            assertEquals(heap.size, i + 1)
        }
        for (i in IntRange(0, 9)) {
            val data = heap.extract()
            assertEquals(data, 9 - i)
            assertEquals(heap.size, 9 - i)
        }
    }

    @Test
    fun example() {
        val heap = Heap(compare_int)
        heap.insert(5)
        heap.insert(10)
        heap.insert(20)
        heap.insert(1)
        heap.insert(25)
        heap.insert(22)
        heap.insert(9)
        val res = arrayOf(25, 22, 20, 10, 9, 5)
        for (i in res) {
            val data = heap.extract()
            assertEquals(data, i)
        }
    }

}
