package com.yourtion.utils

/**
 * Utils Extensions
 * Created by Yourtion on 13/06/2017.
 */

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}





