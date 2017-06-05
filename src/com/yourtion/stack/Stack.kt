package com.yourtion.stack

import com.yourtion.list.List

/**
 * Created by Yourtion on 05/06/2017.
 */

/**
 * 栈
 */
class Stack : List() {

    /**
     * 向栈中压入一个元素 [data]
     */
    fun push(data: Any) {
        insert_next(data)
    }

    /**
     * 从栈中弹出一个元素
     */
    fun pop(): Any? {
        return remove_next()?.data
    }

    /**
     * 获取栈顶部元素中存储的数据
     */
    fun peek(): Any? {
        return head?.data
    }

}
