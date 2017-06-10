package com.yourtion.stack

import com.yourtion.list.List

/**
 * Stack
 * Created by Yourtion on 05/06/2017.
 */

/**
 * 栈
 */
class Stack<E> : List<E>() {

    /**
     * 向栈中压入一个元素 [data]
     */
    fun push(data: E) {
        insert_next(data)
    }

    /**
     * 从栈中弹出一个元素
     */
    fun pop(): E? {
        return remove_next()?.data
    }

    /**
     * 获取栈顶部元素中存储的数据
     */
    fun peek(): E? {
        return head?.data
    }

}
