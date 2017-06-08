package com.yourtion.heap

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Yourtion on 07/06/2017.
 */
class HeapTest {

    val compare_int = { data1: Any, data2: Any -> data1 as Int - data2 as Int }

    @Test
    fun insert() {
        val heap = Heap(compare_int)
        for (i in IntRange(0, 9)) {
            heap.insert(i)
            assertEquals(heap.size, i+1)
        }
        for (i in IntRange(0, 9).reversed()) {
            heap.insert(i*10)
            assertEquals(heap.size, 20 - i)
        }
    }

    @Test
    fun extract() {
        val heap = Heap(compare_int)
        for (i in IntRange(0, 9)) {
            heap.insert(i)
            assertEquals(heap.size, i+1)
        }
        for (i in IntRange(0, 9)) {
            val data = heap.extract()
            assertEquals(data, 9 - i)
            assertEquals(heap.size, 9 - i)
        }
    }

}