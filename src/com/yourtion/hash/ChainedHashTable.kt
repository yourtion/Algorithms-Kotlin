package com.yourtion.hash

import com.yourtion.list.List
import com.yourtion.list.ListElmt

/**
 * Created by Yourtion on 05/06/2017.
 */

/**
 * 链式哈希表
 */
class ChainedHashTable constructor(buckets: Int, hash: (Any) -> Int) {

    val buckets = buckets
    val hash = hash
    var size = 0
    internal val table = Array(buckets, { _ -> List() })

    fun insert(data: Any): Boolean {
        if (lookup(data)) return false
        val bk = hash(data) % buckets
        table[bk].insert_next(data)
        size++
        return true
    }

    fun remove(data: Any): Boolean {
        val bk = hash(data) % buckets
        var element = table[bk].head
        var prev: ListElmt? = null
        while (element != null) {
            if (element.data == data) {
                table[bk].remove_next(prev)
                size--
                return true
            }
            prev = element
            element = element.next
        }

        return false
    }

    fun lookup(data: Any): Boolean {
        val bk = hash(data) % buckets
        var element = table[bk].head
        while (element != null) {
            if (element.data == data) {
                return true
            }
            element = element.next
        }
        return false
    }
}
