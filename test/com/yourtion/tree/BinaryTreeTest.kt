package com.yourtion.tree

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by Yourtion on 06/06/2017.
 */
class BinaryTreeTest {
    @Test
    fun insert_left() {
        val tree = BinaryTree()
        val a = tree.insert_left("A")
        assertNotNull(a)
        assertEquals(tree.root, a)
        val b = tree.insert_left("B", a)
        assertNotNull(b)
        assertEquals(a!!.left, b)
        val c = tree.insert_left("B", b)
        assertNotNull(c)
        assertEquals(b!!.left, c)
        val a1 = tree.insert_left("X")
        assertNull(a1)
    }

    @Test
    fun insert_right() {
        val tree = BinaryTree()
        val a = tree.insert_right("A")
        assertNotNull(a)
        assertEquals(tree.root, a)
        val b = tree.insert_right("B", a)
        assertNotNull(b)
        assertEquals(a!!.right, b)
        val c = tree.insert_right("B", b)
        assertNotNull(c)
        assertEquals(b!!.right, c)
        val a1 = tree.insert_right("X")
        assertNull(a1)
    }

    @Test
    fun remove_left() {
        val tree = BinaryTree()
        val a = tree.insert_left("A")
        val b1 = tree.insert_left("B1", a)
        val b2 = tree.insert_right("B2", a)
        tree.insert_left("C1", b1)
        tree.insert_right("C2", b1)
        tree.remove_left(b2)
        assertNull(b2!!.left)
        tree.remove_left(a)
        assertNull(a!!.left)
        tree.remove_left()
        assertNull(tree.root)
    }

    @Test
    fun remove_right() {
        val tree = BinaryTree()
        val a = tree.insert_right("A")
        val b1 = tree.insert_left("B1", a)
        val b2 = tree.insert_right("B2", a)
        tree.insert_left("C1", b2)
        tree.insert_right("C2", b2)
        tree.remove_right(b2)
        assertNull(b2!!.right)
        tree.remove_right(a)
        assertNull(a!!.right)
        tree.remove_right()
        assertNull(tree.root)
    }

    @Test
    fun is_eob() {
        val tree = BinaryTree()
        val a = tree.insert_right("A")
        assertFalse(BinaryTree.is_eob(a))
        assertTrue(BinaryTree.is_eob(null))
    }

    @Test
    fun is_leaf() {
        val tree = BinaryTree()
        val a = tree.insert_right("A")
        val b1 = tree.insert_left("B1", a)
        val b2 = tree.insert_right("B2", a)
        assertTrue(BinaryTree.is_leaf(b1!!))
        assertTrue(BinaryTree.is_leaf(b2!!))
        assertFalse(BinaryTree.is_leaf(a!!))

    }

    @Test
    fun merge() {
        val tree1 = BinaryTree()
        val a1 = tree1.insert_right("A1")
        val b1 = tree1.insert_left("B1", a1)

        val tree2 = BinaryTree()
        val a2 = tree2.insert_left("a1")
        val b2 = tree2.insert_right("b1", a2)

        val tree = BinaryTree.merge("Aa", tree1, tree2)
        assertEquals(tree.root!!.data, "Aa")
        assertEquals(tree.root!!.left!!.data, "A1")
        assertEquals(tree.root!!.right!!.data, "a1")
        assertEquals(tree.root!!.left!!.left, b1)
        assertEquals(tree.root!!.right!!.right, b2)
    }
}