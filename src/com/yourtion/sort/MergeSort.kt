package com.yourtion.sort

import com.yourtion.list.List

/**
 * Merge sort
 * Created by Yourtion on 13/06/2017.
 */

private fun <T> MutableList<T>.marge(c: Comparator<T>, i: Int, j: Int, k: Int) {
    var ipos = i
    var jpos = j + 1
    var mpos = 0
    val temp = mutableListOf<T>()
    while (ipos <= j || jpos <= k) {
        if (ipos > j) {
            while (jpos <= k) {
                temp.add(mpos, this[jpos])
                jpos++
                mpos++
            }
            continue
        } else if (jpos > k) {
            while (ipos <= j) {
                temp.add(mpos, this[ipos])
                ipos++
                mpos++
            }
            continue
        }

        if (c.compare(this[ipos], this[jpos]) < 0) {
            temp.add(mpos, this[ipos])
            ipos++
            mpos++
        } else {
            temp.add(mpos, this[jpos])
            jpos++
            mpos++
        }
    }
    for ((index, this_i) in IntRange(i, k).withIndex()) this[this_i] = temp[index]
}

/**
 * 归并排序
 */
fun <T> MutableList<T>.mg_sort(c: Comparator<T>, i: Int = 0, k: Int = this.size - 1) {
    val j: Int = ((i + k - 1) / 2)
    if (i < k) {
        mg_sort(c, i, j)
        mg_sort(c, j + 1, k)
        marge(c, i, j, k)
    }
}

/**
 * 归并排序
 */
fun <E> Iterable<E>.mg_sort(comparator: Comparator<E>): List<E> {
    val res: MutableList<E> = mutableListOf()
    this.forEach({ it -> res.add(it) })
    res.mg_sort(comparator)
    val result = List<E>()
    res.forEach { it -> result.insert_next(it, result.tail) }
    return result
}
