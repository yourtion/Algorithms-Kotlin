package com.yourtion.tree

import com.yourtion.list.List
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Yourtion on 06/06/2017.
 */
class AVLTreeTest {

    val comp = { data1: Any, data2: Any -> data1 as Int - data2 as Int }

    @Test
    fun rotate_left() {
        val a0 = AVLTree.AvlNode("A")
        val a22 = AVLTree.AvlNode("22")
        val a15 = AVLTree.AvlNode("15")
        val a43 = AVLTree.AvlNode("43")
        val a75 = AVLTree.AvlNode("75")
        val x = AVLTree.AvlNode("X")

        a0.left = a22
        a0.right = a75
        a22.left = a15
        a22.right = a43
        a15.left = x

        val a = AVLTree(comp).rotate_left(a0)
        assertEquals(a.data, "22")
        assertEquals((a.left as AVLTree.AvlNode).data, "15")
        assertEquals((a.right as AVLTree.AvlNode).data, "A")
        assertEquals((a.left as AVLTree.AvlNode).left!!.data, "X")
        assertEquals((a.right as AVLTree.AvlNode).left!!.data, "43")
        assertEquals((a.right as AVLTree.AvlNode).right!!.data, "75")
    }

    @Test
    fun rotate_left_right() {
        val a0 = AVLTree.AvlNode("A")
        val a22 = AVLTree.AvlNode("22")
        val a15 = AVLTree.AvlNode("15")
        val a43 = AVLTree.AvlNode("43")
        val a75 = AVLTree.AvlNode("75")
        val x = AVLTree.AvlNode("X")

        a0.left = a22
        a0.right = a75
        a22.left = a15
        a22.right = a43
        a43.left = x

        val a = AVLTree(comp).rotate_left_right(a0)
        assertEquals(a.data, "43")
        assertEquals((a.left as AVLTree.AvlNode).data, "22")
        assertEquals((a.right as AVLTree.AvlNode).data, "A")
        assertEquals((a.left as AVLTree.AvlNode).left!!.data, "15")
        assertEquals((a.left as AVLTree.AvlNode).right!!.data, "X")
        assertEquals((a.right as AVLTree.AvlNode).right!!.data, "75")
    }

    fun verify(list: List, order: Array<Int>) {
        var element = list.head
        for (i in IntRange(0, list.size - 1)) {
            assertEquals(element!!.data, order[i])
            element = element.next
        }
    }

    @Test
    fun insert() {
        val tree = AVLTree(comp)
        tree.insert(9)
        tree.insert(8)
        tree.insert(3)
        tree.insert(4)
        tree.insert(0)
        tree.insert(5)
        tree.insert(6)
        tree.insert(7)
        tree.insert(2)
        tree.insert(6)
        tree.insert(1)
        val list = tree.pre_order()
        assertEquals(list.size, 10)
        verify(list, arrayOf(6, 2, 0, 1, 4, 3, 5, 8, 7, 9))
    }

    @Test
    fun remove() {
    }

    @Test
    fun lookup() {
    }

}
