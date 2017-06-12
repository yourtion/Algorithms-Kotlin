package com.yourtion.set

import com.yourtion.list.List

/**
 * Set
 * Created by Yourtion on 02/06/2017.
 */

/**
 * 集合
 */
class Set<E> : List<E>() {

    /**
     * 在集合中插入一个成员 [data]
     *
     * @param data 数据
     */
    fun insert(data: E): Boolean {
        if (is_member(data)) return false
        super.insert_next(data, tail)
        return true
    }

    /**
     * 在集合中移除数据域同 data 相吻合的成员
     *
     * @param data 数据
     */
    fun remove(data: E): Boolean {
        val this_it = this.iterator()
        for (member in this_it) if (member == data) {
            this_it.remove()
            return true
        }
        return false
    }

    /**
     * 判断由 [data] 所指定成员是否存在于集合
     *
     * @param data 数据
     */
    fun is_member(data: E): Boolean {
        return this.contains(data)
    }

    /**
     * 判断 [set] 所指定集合是否为集合的子集
     *
     * @param set 待判断集合
     */
    fun is_subset(set: Set<E>): Boolean {
        if (size > set.size) return false
        return this.all { set.is_member(it) }
    }

    /**
     * 判断 [set] 所指定集合是否等于本集合
     *
     * @param set 待判断集合
     */
    fun is_equal(set: Set<E>): Boolean {
        if (size != set.size) return false
        return is_subset(set)
    }

    /**
     * 计算 [set] 所指定集合与本集合的并集
     *
     * @param set 集合
     */
    fun union(set: Set<E>): Set<E> {
        val setu = Set<E>()

        this.forEach { member -> setu.insert_next(member, setu.tail) }

        set.filterNot { setu.is_member(it) }.forEach { setu.insert_next(it, setu.tail) }

        return setu
    }

    /**
     * 计算 [set] 所指定集合与本集合的交集
     *
     * @param set 集合
     */
    fun intersection(set: Set<E>): Set<E> {
        val seti = Set<E>()
        this.filter { set.is_member(it) }.forEach { seti.insert_next(it, seti.tail) }
        return seti
    }

    /**
     * 计算 [set] 所指定集合与本集合的差集
     *
     * @param set 集合
     */
    fun difference(set: Set<E>): Set<E> {
        val setd = Set<E>()
        this.filterNot { set.is_member(it) }.forEach { setd.insert_next(it, setd.tail) }
        return setd
    }
}
