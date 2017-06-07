package com.yourtion.tree

import com.yourtion.list.List
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Yourtion on 06/06/2017.
 */
class TraverseKtTest {

    fun buildTree() :BinaryTree {
        val tree = BinaryTree()
        val a = tree.insert_left("A")
        val b1 = tree.insert_left("B1", a)
        val b2 = tree.insert_right("B2", a)
        tree.insert_right("C2", b1)
        tree.insert_left("D1", b2)
        tree.insert_right("D2", b2)
        return tree
    }

    fun verify(list:List, order: Array<String>) {
        var element = list.head
        for (i in IntRange(0, list.size - 1)) {
            assertEquals(element!!.data, order[i])
            element = element.next
        }
    }

    @Test
    fun pre_order() {
        val list = buildTree().pre_order()
        assertEquals(list.size, 6)
        verify(list, arrayOf("A", "B1", "C2", "B2", "D1", "D2"))
    }

    @Test
    fun in_order() {
        val list = buildTree().in_order()
        assertEquals(list.size, 6)
        verify(list, arrayOf( "B1", "C2", "A", "D1", "B2", "D2"))
    }

    @Test
    fun post_order() {
        val list = buildTree().post_order()
        assertEquals(list.size, 6)
        verify(list, arrayOf( "C2", "B1", "D1", "D2", "B2", "A"))
    }

}