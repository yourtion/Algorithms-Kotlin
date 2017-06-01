package com.yourtion.list

/**
 * Created by Yourtion on 01/06/2017.
 */


/**
 * 链表元素
 */
class ListElmt(val data: Any, var next: ListElmt? = null)

/**
 * 链表
 */
class List {
    var size = 0
    var match: Function<Boolean>? = null
    var head: ListElmt? = null
    var tail: ListElmt? = null

    /**
     * 在 [element] 后面插入一个新元素
     *
     * @param data 元素数据
     * @param element 新元素，如果为 NULL 则插入头部
     *
     * @return 新插入元素
     */
    fun insert_next(data: Any, element: ListElmt? = null): ListElmt {
        val new_element = ListElmt(data)

        if (element == null) {
            // 处理插入到头部
            if (size == 0) {
                tail = new_element
            }

            new_element.next = head
            head = new_element
        } else {
            // 处理插入到其他位置
            if (element.next == null) {
                tail = new_element
            }

            new_element.next = element.next
            element.next = new_element
        }

        size++

        return new_element
    }

    /**
     * 移除 [element] 后的元素
     *
     * @param element 待移除元素前面的元素，如果为 NULL 则移除头部
     *
     * @return 被删除元素
     */
    fun remove_next(element: ListElmt? = null): ListElmt? {
        // 禁止删除空链表的数据
        if (size == 0) return null

        var old_element: ListElmt? = null

        if (element == null) {
            // 处理删除头部元素
            old_element = head
            head = head?.next

            if (size == 1) {
                tail = null
            }
        } else {
            // 处理其他情况
            if (element.next == null) return null

            old_element = element.next
            element.next = old_element?.next

            if (element.next == null) {
                tail = element
            }
        }

        size--

        return old_element
    }

    /**
     * 判断元素 [element] 是否为头节点
     */
    fun is_head(element: ListElmt): Boolean {
        return element === head
    }

    /**
     * 判断元素 [element] 是否为尾节点
     */
    fun is_tail(element: ListElmt): Boolean {
        return element === tail
    }
}
