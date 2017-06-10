package com.yourtion.stack

import com.yourtion.list.List

/**
 * Queue
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 队列
 */
open class Queue<E> : List<E>() {

    /**
     * 将 [data] 入队
     */
    fun enqueue(data: E): ListElmt<E> {
        return insert_next(data, tail)
    }

    /**
     * 出队
     */
    fun dequeue(): E? {
        return remove_next()?.data
    }

    /**
     * 获取队列头部元素中存储数据
     */
    fun peek(): E? {
        return head?.data
    }
}
