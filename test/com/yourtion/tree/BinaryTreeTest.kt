package com.yourtion.tree

import com.yourtion.list.List
import com.yourtion.tree.TraverseOrder.*
import org.junit.Assert.*
import org.junit.Test

/**
 * BinaryTreeTest
 * Created by Yourtion on 06/06/2017.
 */
class BinaryTreeTest {
    @Test
    fun insert_left() {
        val tree = BinaryTree<String>()
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
        val tree = BinaryTree<String>()
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
        val tree = BinaryTree<String>()
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
        val tree = BinaryTree<String>()
        val a = tree.insert_right("A")
        val b2 = tree.insert_right("B2", a)
        tree.insert_left("B1", a)
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
    fun is_leaf() {
        val tree = BinaryTree<String>()
        val a = tree.insert_right("A")
        val b1 = tree.insert_left("B1", a)
        val b2 = tree.insert_right("B2", a)
        assertTrue(BinaryTree.is_leaf(b1!!))
        assertTrue(BinaryTree.is_leaf(b2!!))
        assertFalse(BinaryTree.is_leaf(a!!))

    }

    @Test
    fun merge() {
        val tree1 = BinaryTree<String>()
        val a1 = tree1.insert_right("A1")
        val b1 = tree1.insert_left("B1", a1)

        val tree2 = BinaryTree<String>()
        val a2 = tree2.insert_left("a1")
        val b2 = tree2.insert_right("b1", a2)

        val tree = BinaryTree.merge("Aa", tree1, tree2)
        assertEquals(tree.root!!.data, "Aa")
        assertEquals(tree.root!!.left!!.data, "A1")
        assertEquals(tree.root!!.right!!.data, "a1")
        assertEquals(tree.root!!.left!!.left, b1)
        assertEquals(tree.root!!.right!!.right, b2)
    }

    fun verify(list: List<Int>, order: Array<Int>) {
        var element = list.head
        for (i in IntRange(0, list.size - 1)) {
            assertEquals(element!!.data, order[i])
            element = element.next
        }
    }

    fun BinaryTree<Int>.insert_int(i: Int) {
        var node = root
        var prev: BinaryTree.BinaryTreeNode<Int>? = null
        var dir = 0

        while (node != null) {
            prev = node
            if (i == node.data) return
            if (i < node.data) {
                node = node.left
                dir = 1
            } else {
                node = node.right
                dir = 2
            }
        }

        when (dir) {
            0 -> insert_left(i)
            1 -> insert_left(i, prev)
            2 -> insert_right(i, prev)
        }
    }

    fun BinaryTree<Int>.search_int(i: Int): BinaryTree.BinaryTreeNode<Int>? {
        var node = root

        while (node != null) {
            if (i == node.data) return node
            if (i < node.data) {
                node = node.left
            } else {
                node = node.right
            }
        }
        return null
    }

    @Test
    fun example() {
        val tree = BinaryTree<Int>()
        tree.insert_int(20)
        tree.insert_int(30)
        tree.insert_int(10)
        tree.insert_int(5)
        tree.insert_int(15)
        tree.insert_int(25)
        tree.insert_int(23)
        tree.insert_int(26)
        tree.insert_int(70)
        tree.insert_int(80)

        println("Test inserted nodes")
        var list = tree.order(PreOrder)
        verify(list, arrayOf(20, 10, 5, 15, 30, 25, 23, 26, 70, 80))

        println("Searching the node 30")
        var node = tree.search_int(30)
        assertEquals(node!!.data, 30)
        println("Removing the left tree below 30")
        tree.remove_left(node)
        list = tree.order(PreOrder)
        verify(list, arrayOf(20, 10, 5, 15, 30, 70, 80))

        println("Searching the node 90")
        node = tree.search_int(90)
        assertNull(node)

        println("Searching the node 20")
        node = tree.search_int(20)
        assertEquals(node!!.data, 20)
        println("Removing the right tree below 20")
        tree.remove_right(node)
        list = tree.order(PreOrder)
        verify(list, arrayOf(20, 10, 5, 15))

        println("Testing is_leaf root")
        assertFalse(BinaryTree.is_leaf(tree.root!!))
        println("Testing is_leaf root->left")
        assertFalse(BinaryTree.is_leaf(tree.root!!.left!!))
        println("Testing is_leaf root->left->left")
        assertTrue(BinaryTree.is_leaf(tree.root!!.left!!.left!!))
        println("Testing is_leaf root->left->right")
        assertTrue(BinaryTree.is_leaf(tree.root!!.left!!.right!!))

        println("Testing traversal")
        tree.insert_int(40)
        tree.insert_int(90)
        list = tree.order(PreOrder)
        verify(list, arrayOf(20, 10, 5, 15, 40, 90))
        list = tree.order(InOrder)
        verify(list, arrayOf(5, 10, 15, 20, 40, 90))
        list = tree.order(PostOrder)
        verify(list, arrayOf(5, 15, 10, 90, 40, 20))
    }
}
