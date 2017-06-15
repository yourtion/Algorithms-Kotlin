package com.yourtion.utils

import com.yourtion.list.DList
import com.yourtion.list.List
import org.junit.Assert.assertEquals

/**
 * Utils
 * Created by Yourtion on 13/06/2017.
 */

val compare_int = { data1: Int, data2: Int -> data1 - data2 }
val compare_string = { data1: String, data2: String -> data1.compareTo(data2) }

fun verify_string(list: List<String>, str: String, split: String = "") {
    val res = str.split(split).filter { it != "" }
    for ((index, data) in list.withIndex()) {
        assertEquals(data, res[index])
    }
}

fun <E> verify(list: List<E>, res: Array<E>) {
    for ((index, data) in list.withIndex()) {
        assertEquals(data, res[index])
    }
}

fun <E> verify(list: DList<E>, res: Array<E>) {
    for ((index, data) in list.withIndex()) {
        assertEquals(data, res[index])
    }
}

