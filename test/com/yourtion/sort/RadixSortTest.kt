package com.yourtion.sort

import com.yourtion.utils.verify
import org.junit.Assert
import org.junit.Test

/**
 * RadixSortTest
 * Created by Yourtion on 14/06/2017.
 */
class RadixSortTest {

    @Test
    fun rx_sort_int() {
        val list = com.yourtion.list.List<Int>()
        list.insert_next(11111323)
        list.insert_next(99283743)
        list.insert_next(98298383)
        list.insert_next(99987444)
        list.insert_next(43985209)
        list.insert_next(99911110)
        list.insert_next(11111324)
        list.insert_next(39842329)
        list.insert_next(97211029)
        list.insert_next(99272928)
        val ret = list.rx_sort(10, 8)
        ret.print()
        verify(ret, arrayOf(11111323, 11111324, 39842329, 43985209, 97211029, 98298383, 99272928, 99283743, 99911110, 99987444))
    }

    @Test
    fun rx_sort_int_array() {
        val list = arrayListOf(11111323, 99283743, 98298383, 99987444, 43985209, 99911110, 11111324, 39842329, 97211029, 99272928)
        list.ct_sort()
        Assert.assertEquals(list, arrayListOf(11111323, 11111324, 39842329, 43985209, 97211029, 98298383, 99272928, 99283743, 99911110, 99987444))
    }
}
