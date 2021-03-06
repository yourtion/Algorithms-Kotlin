package com.yourtion.tree

import com.yourtion.utils.compare_int
import com.yourtion.utils.compare_string
import com.yourtion.utils.verify
import org.junit.Assert.*
import org.junit.Test

/**
 * AVLTreeTest
 * Created by Yourtion on 06/06/2017.
 */
class AVLTreeTest {

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

        val a = AVLTree(Comparator(compare_string)).rotate_left(a0)
        assertEquals(a.data, "22")
        assertEquals(a.left!!.data, "15")
        assertEquals(a.right!!.data, "A")
        assertEquals(a.left!!.left!!.data, "X")
        assertEquals(a.right!!.left!!.data, "43")
        assertEquals(a.right!!.right!!.data, "75")
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

        val a = AVLTree(Comparator(compare_string)).rotate_left_right(a0)
        assertEquals(a.data, "43")
        assertEquals(a.left!!.data, "22")
        assertEquals(a.right!!.data, "A")
        assertEquals(a.left!!.left!!.data, "15")
        assertEquals(a.left!!.right!!.data, "X")
        assertEquals(a.right!!.right!!.data, "75")
    }

    fun build_tree(): AVLTree<Int> {
        val tree = AVLTree<Int>(Comparator(compare_int))
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
        return tree
    }

    @Test
    fun insert() {
        val tree = build_tree()
        val list = tree.pre_order()
        assertEquals(list.size, 10)
        verify(list, arrayOf(6, 2, 0, 1, 4, 3, 5, 8, 7, 9))
    }

    @Test
    fun remove() {
        val tree = build_tree()
        tree.remove(6)
        tree.remove(0)
        tree.remove(9)
        tree.remove(3)
        tree.remove(2)
        tree.remove(8)
        val list = tree.pre_order()
        assertEquals(list.size, 4)
        for (i in IntRange(0, 9)) {
            tree.remove(i)
        }
        assertNull(tree.root)
    }

    @Test
    fun lookup() {
        val tree = build_tree()
        assertTrue(tree.lookup(0))
        assertTrue(tree.lookup(9))
        assertTrue(tree.lookup(3))
        assertTrue(tree.lookup(5))
        assertFalse(tree.lookup(11))
        assertFalse(tree.lookup(-1))
        tree.remove(0)
        assertFalse(tree.lookup(0))
    }

    @Test
    fun example() {
        val tree = AVLTree(Comparator(compare_string))
        println("Inserting some nodes")
        tree.insert("tap")
        tree.insert("tip")
        tree.insert("top")
        tree.insert("cat")
        tree.insert("bat")
        var list = tree.pre_order()
        assertEquals(list.size, 5)
        verify(list, arrayOf("tip", "cat", "bat", "tap", "top"))

        println("Removing tip")
        tree.remove("tip")
        println("Removing hop")
        tree.remove("hop")
        println("Inserting more nodes")
        tree.insert("hop")
        tree.insert("dip")
        tree.insert("tap")
        tree.insert("top")
        tree.insert("tip")
        tree.insert("mom")
        tree.insert("hat")
        tree.insert("mop")
        tree.insert("wax")
        tree.insert("zoo")
        list = tree.pre_order()
        assertEquals(list.size, 12)

        println("Removing hop and wax again")
        tree.remove("hop")
        tree.remove("wax")
        list = tree.pre_order()
        assertEquals(list.size, 10)

        println("Looking up some nodes")
        assertTrue(tree.lookup("top"))
        assertFalse(tree.lookup("hop"))
        assertFalse(tree.lookup("wax"))
        assertTrue(tree.lookup("hat"))
        assertFalse(tree.lookup("xxx"))
    }

}
