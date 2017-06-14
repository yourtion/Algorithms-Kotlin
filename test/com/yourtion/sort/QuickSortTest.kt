package com.yourtion.sort

import com.yourtion.utils.compare_int
import com.yourtion.utils.compare_string
import com.yourtion.utils.verify
import com.yourtion.utils.verify_string
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * QuickSort Test
 * Created by Yourtion on 13/06/2017.
 */
class QuickSortTest {

    @Test
    fun qk_sort_int() {
        val list = com.yourtion.list.List<Int>()
        list.insert_next(1)
        list.insert_next(4)
        list.insert_next(3)
        list.insert_next(-1)
        list.insert_next(5)
        list.insert_next(-2)
        list.insert_next(0)
        list.insert_next(2)
        val ret = list.qk_sort(Comparator(compare_int))
        ret.print()
        verify(ret, arrayOf(-2, -1, 0, 1, 2, 3, 4, 5))
    }

    @Test
    fun qk_sort_string() {
        val list = com.yourtion.list.List<String>()
        list.insert_next("c")
        list.insert_next("a")
        list.insert_next("d")
        list.insert_next("f")
        list.insert_next("e")
        list.insert_next("A")
        list.insert_next("C")
        list.insert_next("B")
        val ret = list.qk_sort(Comparator(compare_string))
        ret.print()
        verify_string(ret, "ABCacdef")
    }

    @Test
    fun qk_sort_int_array() {
        val list = arrayListOf(1, 4, 3, -1, 5, -2, 0, 2)
        list.qk_sort(Comparator(compare_int))
        assertEquals(list, arrayListOf(-2, -1, 0, 1, 2, 3, 4, 5))
    }

}
