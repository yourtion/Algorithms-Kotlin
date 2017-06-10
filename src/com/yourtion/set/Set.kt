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
        var member = head
        var prev: ListElmt<E>? = null
        while (member != null) {
            if (member.data == data) {
                break
            }
            prev = member
            member = member.next
        }

        if (member == null) return false

        super.remove_next(prev)
        return true
    }

    /**
     * 判断由 [data] 所指定成员是否存在于集合
     *
     * @param data 数据
     */
    fun is_member(data: E): Boolean {
        var member = head
        while (member != null) {
            if (member.data == data) {
                return true
            }
            member = member.next
        }

        return false
    }

    /**
     * 判断 [set] 所指定集合是否为集合的子集
     *
     * @param set 待判断集合
     */
    fun is_subset(set: Set<E>): Boolean {
        if (size > set.size) return false

        var member = head
        while (member != null) {
            if (!set.is_member(member.data)) {
                return false
            }
            member = member.next
        }
        return true
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

        var member = head
        while (member != null) {
            setu.insert_next(member.data, setu.tail)
            member = member.next
        }

        member = set.head
        while (member != null) {
            if (!setu.is_member(member.data)) {
                setu.insert_next(member.data, setu.tail)
            }
            member = member.next
        }

        return setu
    }

    /**
     * 计算 [set] 所指定集合与本集合的交集
     *
     * @param set 集合
     */
    fun intersection(set: Set<E>): Set<E> {
        val seti = Set<E>()

        var member = head
        while (member != null) {
            if (set.is_member(member.data)) {
                seti.insert_next(member.data, seti.tail)
            }
            member = member.next
        }

        return seti
    }

    /**
     * 计算 [set] 所指定集合与本集合的差集
     *
     * @param set 集合
     */
    fun difference(set: Set<E>): Set<E> {
        val setd = Set<E>()

        var member = head
        while (member != null) {
            if (!set.is_member(member.data)) {
                setd.insert_next(member.data, setd.tail)
            }
            member = member.next
        }

        return setd
    }
}
