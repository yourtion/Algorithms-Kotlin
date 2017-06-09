package com.yourtion.list

/**
 * Created by Yourtion on 01/06/2017.
 */

/**
 * 循环链表
 */
class CList {

    /**
     * 循环链表元素
     */
    class CListElmt(val data: Any, var next: CListElmt? = null)

    var size = 0
        private set
    var head: CListElmt? = null
        private set

    /**
     * 在 [element] 后面插入一个新元素
     *
     * @param data 元素数据
     * @param element 新元素
     *
     * @return 新插入元素
     */
    fun insert_next(data: Any, element: CListElmt? = null): CListElmt? {
        if (element == null && size != 0) return null

        val new_element = CListElmt(data)

        if (size == 0) {
            // 处理插入空循环链表
            new_element.next = new_element
            head = new_element
        } else {
            // 处理非空情况
            new_element.next = element!!.next
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
    fun remove_next(element: CListElmt): CListElmt? {
        // 禁止删除空链表的数据
        if (size == 0) return null

        val old_element = element.next!!

        if (element.next == element) {
            // 处理删除最后一个元素
            head = null

        } else {
            // 处理其他情况
            element.next = element.next!!.next

            if (is_head(old_element)) {
                head = old_element.next
            }
        }

        size--

        return old_element
    }

    /**
     * 判断元素 [element] 是否为头节点
     */
    fun is_head(element: CListElmt): Boolean {
        return element === head
    }

}
