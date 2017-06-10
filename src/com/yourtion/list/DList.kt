package com.yourtion.list

/**
 * Doubly-linked List
 * Created by Yourtion on 01/06/2017.
 */

/**
 * 双向链表
 */
class DList<E> {

    /**
     * 双向链表节点
     */
    data class DListElmt<E>(val data: E, var prev: DListElmt<E>? = null, var next: DListElmt<E>? = null)

    var size = 0
        private set
    var head: DListElmt<E>? = null
        private set
    var tail: DListElmt<E>? = null
        private set

    /**
     * 在 [element] 后面插入一个新元素
     *
     * @param data 元素数据
     * @param element 新元素，如果为 NULL 则插入空链表中
     *
     * @return 新插入元素
     */
    fun insert_next(data: E, element: DListElmt<E>? = null): DListElmt<E>? {
        // 除非是空双向链表，否则不允许 element 为 NULL
        if (element == null && size != 0) return null

        val new_element = DListElmt(data)

        if (size == 0) {
            // 处理空双向链表
            head = new_element
            tail = new_element

        } else {
            // 处理非空双向链表
            new_element.next = element!!.next
            new_element.prev = element

            if (element.next == null) {
                tail = new_element
            } else {
                element.next!!.prev = new_element
            }

            element.next = new_element
        }

        size++

        return new_element
    }

    /**
     * 在 [element] 前面插入一个新元素
     *
     * @param data 元素数据
     * @param element 新元素，如果为 NULL 则插入空链表中
     *
     * @return 新插入元素
     */
    fun insert_prev(data: E, element: DListElmt<E>? = null): DListElmt<E>? {
        // 除非是空双向链表，否则不允许 element 为 NULL
        if (element == null && size != 0) return null

        val new_element = DListElmt(data)

        if (size == 0) {
            // 处理空双向链表
            head = new_element
            tail = new_element

        } else {
            // 处理非空双向链表
            new_element.next = element
            new_element.prev = element!!.prev

            if (element.prev == null) {
                head = new_element
            } else {
                element.prev!!.next = new_element
            }

            element.prev = new_element
        }

        size++

        return new_element
    }

    /**
     * 移除 [element] 元素
     *
     * @param element 待移除元素
     *
     * @return 被删除元素
     */
    fun remove(element: DListElmt<E>): DListElmt<E>? {
        // 禁止删除 element 为空或空链表的数据
        if (size == 0) return null

        val old_element = element

        if (is_head(element)) {
            // 处理删除头部元素
            head = element.next
            if (head == null) {
                tail = null
            } else {
                element.next!!.prev = null
            }
        } else {
            // 处理删除非头部元素
            element.prev!!.next = element.next

            if (element.next == null) {
                tail = element.prev
            } else {
                element.next!!.prev = element.prev
            }
        }

        size--

        return old_element
    }

    /**
     * 判断元素 [element] 是否为头节点
     */
    fun is_head(element: DListElmt<E>): Boolean {
        return element === head
    }

    /**
     * 判断元素 [element] 是否为尾节点
     */
    fun is_tail(element: DListElmt<E>): Boolean {
        return element === tail
    }

    fun print() {
        if (size == 0) return println("-> $this is Empty")
        var str = "-> $this size: $size \n-"
        var element = head
        while (element != null) {
            str += "-> [" + element.data.toString() + "] "
            element = element.next
        }
        str += "\n"
        print(str)
    }

}
