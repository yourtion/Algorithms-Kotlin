package com.yourtion.hash

import com.yourtion.list.List

/**
 * Created by Yourtion on 05/06/2017.
 */

/**
 * 链式哈希表
 */
class ChainedHashTable constructor(buckets: Int, hash: (Any) -> Int) {

    // 桶数量
    val buckets = buckets
    // 哈希函数
    val hash = hash
    // 元素数量
    var size = 0
    // 哈希表
    internal val table = Array(buckets, { _ -> List() })

    /**
     * 向链式哈希表中插入一个元素 [data]
     */
    fun insert(data: Any): Boolean {
        if (lookup(data)) return false
        val bk = hash(data) % buckets
        table[bk].insert_next(data)
        size++
        return true
    }

    /**
     * 从链式哈希表中删除与 [data] 匹配的元素
     */
    fun remove(data: Any): Boolean {
        val bk = hash(data) % buckets
        var element = table[bk].head
        var prev: List.ListElmt? = null
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

    /**
     * 判断链式哈希表中查找是否有与 [data] 相匹配的元素
     */
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
