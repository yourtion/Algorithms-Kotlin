package com.yourtion.stack

import com.yourtion.list.List

/**
 * Created by Yourtion on 05/06/2017.
 */
class Stack : List() {

    fun push(data: Any) {
        insert_next(data)
    }

    fun pop(): Any? {
        return remove_next()?.data
    }

    fun peek(): Any? {
        return head?.data
    }

}
