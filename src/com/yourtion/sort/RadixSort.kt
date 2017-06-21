package com.yourtion.sort

import com.yourtion.list.List
import java.lang.Math.pow

/**
 * Radix sort
 * Created by Yourtion on 14/06/2017.
 */

/**
 * 基数排序
 */
fun MutableList<Int>.rx_sort(k: Int, p: Int) {
    val temp = IntArray(size, { _ -> 0 })
    for (n in IntRange(0, p - 1)) {
        val counts: IntArray = IntArray(k, { _ -> 0 })
        val pval = pow(k.toDouble(), n.toDouble()).toInt()

        var index: Int
        for (j in IntRange(0, size - 1)) {
            index = (this[j] / pval) % k
            counts[index]++
        }
        IntRange(1, counts.size - 1).forEach { i -> counts[i] = counts[i] + counts[i - 1] }
        for (j in IntRange(0, size - 1).reversed()) {
            index = (this[j] / pval) % k
            temp[counts[index] - 1] = this[j]
            counts[index]--
        }
        temp.withIndex().forEach { (index, data) -> this[index] = data }
    }
}

/**
 * 基数排序
 */
fun Iterable<Int>.rx_sort(k: Int, p: Int): List<Int> {
    val res: MutableList<Int> = mutableListOf()
    this.forEach({ it -> res.add(it) })
    println(res)
    res.rx_sort(k, p)
    val result = List<Int>()
    res.forEach { it -> result.insert_next(it, result.tail) }
    return result
}
