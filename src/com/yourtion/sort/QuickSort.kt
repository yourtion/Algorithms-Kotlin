package com.yourtion.sort

import com.yourtion.list.List
import com.yourtion.utils.swap

/**
 * Quick Sort
 * Created by Yourtion on 13/06/2017.
 */

private fun <T> MutableList<T>.partition(i: Int, k: Int, c: Comparator<T>): Int {
    val r0 = List(3, { (Math.random() * (k - i + 1) + i).toInt() })
    val r = this[r0.sorted()[1]]
    var i0 = i - 1
    var k0 = k + 1

    while (true) {
        do k0--
        while (c.compare(this[k0], r) > 0)

        do i0++
        while (c.compare(this[i0], r) < 0)

        if (i0 >= k0) {
            break
        } else {
            this.swap(i0, k0)
        }
    }

    return k0
}

/**
 * 快速排序
 */
fun <T> MutableList<T>.qk_sort(c: Comparator<T>, i: Int = 0, k: Int = this.size - 1) {
    if (i < k) {
        val j = this.partition(i, k, c)
        this.qk_sort(c, i, j)
        this.qk_sort(c, j + 1, k)
    }
}

/**
 * 快速排序
 */
fun <E> Iterable<E>.qk_sort(comparator: Comparator<E>): List<E> {
    val res: MutableList<E> = mutableListOf()
    this.forEach({ it -> res.add(it) })
    res.qk_sort(comparator)
    val result = List<E>()
    res.forEach { it -> result.insert_next(it, result.tail) }
    return result
}
