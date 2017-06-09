package com.yourtion.list

/**
 * Queue
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 队列
 */
class Queue : List() {

    /**
     * 将 [data] 入队
     */
    fun enqueue(data: Any): ListElmt {
        return insert_next(data, tail)
    }

    /**
     * 出队
     */
    fun dequeue(): Any? {
        return remove_next()?.data
    }

    /**
     * 获取队列头部元素中存储数据
     */
    fun peek(): Any? {
        return head?.data
    }
}
