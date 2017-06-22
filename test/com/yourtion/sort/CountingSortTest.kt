package com.yourtion.sort

import com.yourtion.utils.verify
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * CountingSortTest
 * Created by Yourtion on 14/06/2017.
 */
class CountingSortTest {

    @Test
    fun ct_sort_int() {
        val list = com.yourtion.list.List<Int>()
        list.insert_next(1)
        list.insert_next(5)
        list.insert_next(4)
        list.insert_next(-2)
        list.insert_next(3)
        list.insert_next(-1)
        list.insert_next(5)
        list.insert_next(-2)
        list.insert_next(0)
        list.insert_next(5)
        list.insert_next(-1)
        list.insert_next(2)
        val ret = list.ct_sort()
        ret.print()
        verify(ret, arrayOf(-2, -2, -1, -1, 0, 1, 2, 3, 4, 5, 5, 5))
    }

    @Test
    fun ct_sort_int_array() {
        val list = arrayListOf(1, 5, 4, -2, 3, -1, 5, -2, 0, 5, -1, 2)
        list.ct_sort()
        assertEquals(list, arrayListOf(-2, -2, -1, -1, 0, 1, 2, 3, 4, 5, 5, 5))
    }

}
