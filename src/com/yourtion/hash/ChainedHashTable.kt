package com.yourtion.hash

import com.yourtion.list.List

/**
 * Chained Hash Table
 * Created by Yourtion on 05/06/2017.
 */

/**
 * 链式哈希表
 */
class ChainedHashTable<E> constructor(buckets: Int, hash: (E) -> Int) {

    // 元素数量
    var size = 0
        private set
    // 哈希表
    internal val table = Array(buckets, { _ -> List<E>() })
    // 桶数量
    private val buckets = buckets
    // 哈希函数
    private val hash = hash
    
    /**
     * 向链式哈希表中插入一个元素 [data]
     */
    fun insert(data: E): Boolean {
        if (lookup(data)) return false
        val bk = hash(data) % buckets
        table[bk].insert_next(data)
        size++
        return true
    }

    /**
     * 从链式哈希表中删除与 [data] 匹配的元素
     */
    fun remove(data: E): Boolean {
        val bk = hash(data) % buckets
        val table_it = table[bk].iterator()
        for (element in table_it) if (element == data) {
            table_it.remove()
            size--
            return true
        }
        return false
    }

    /**
     * 判断链式哈希表中查找是否有与 [data] 相匹配的元素
     */
    fun lookup(data: E): Boolean {
        val bk = hash(data) % buckets
        return table[bk].contains(data)
    }

    fun print() {
        if (size == 0) return println("-> $this is Empty")
        var str = "-> $this size: $size \n"
        for (i in IntRange(0, buckets - 1)) {
            val bucket = table[i]
            str += "--> Bucket[$i] = "
            bucket.forEach { element -> str += element.toString() + " " }
            str += "\n"
        }
        print(str)
    }
}
