package com.yourtion.sort

import com.yourtion.list.List

/**
 * Counting sort
 * Created by Yourtion on 14/06/2017.
 */

/**
 * 计数排序
 */
fun MutableList<Int>.ct_sort() {
    val k = this.max()!! - this.min()!! + 1
    val d = -1 * this.min()!!
    val counts: IntArray = IntArray(k, { _ -> 0 })
    val temp = IntArray(size, { _ -> 0 })
    this.forEach { it -> counts[it + d]++ }
    IntRange(1, counts.size - 1).forEach { i -> counts[i] = counts[i] + counts[i - 1] }
    for (data in this) {
        temp[counts[data + d] - 1] = data
        counts[data + d]--
    }
    temp.withIndex().forEach { (index, data) -> this[index] = data }
}

/**
 * 计数排序
 */
fun Iterable<Int>.ct_sort(): List<Int> {
    val res: MutableList<Int> = mutableListOf()
    this.forEach({ it -> res.add(it) })
    println(res)
    res.ct_sort()
    val result = List<Int>()
    res.forEach { it -> result.insert_next(it, result.tail) }
    return result
}
