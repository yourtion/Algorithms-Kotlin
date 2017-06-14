package com.yourtion.sort

import com.yourtion.list.List
import com.yourtion.utils.swap

/**
 * Insertion sort
 * Created by Yourtion on 12/06/2017.
 */

/**
 * 插入排序
 */
fun <T> MutableList<T>.is_sort(c: Comparator<T>) {
    for ((j, data) in this.withIndex()) {
        var i = j - 1
        while (i >= 0 && c.compare(this[i], data) > 0) {
            this.swap(i, i + 1)
            i--
        }
    }
}

/**
 * 插入排序
 */
fun <E> Iterable<E>.is_sort(comparator: Comparator<E>): List<E> {
    val res: MutableList<E> = mutableListOf()
    this.forEach({ it -> res.add(it) })
    res.is_sort(comparator)
    val result = List<E>()
    res.forEach { it -> result.insert_next(it, result.tail) }
    return result
}
