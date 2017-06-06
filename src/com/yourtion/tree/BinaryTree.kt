package com.yourtion.tree

/**
 * Created by Yourtion on 06/06/2017.
 */
/**
 * 二叉树
 */
class BinaryTree constructor(root: BinaryTreeNode? = null) {

    data class BinaryTreeNode constructor(
            val data: Any,
            var left: BinaryTreeNode? = null,
            var right: BinaryTreeNode? = null
    )

    companion object {

        fun is_eob(node: BinaryTreeNode?): Boolean {
            return node == null
        }

        fun is_leaf(node: BinaryTreeNode): Boolean {
            return node.left == null && node.right == null
        }

        fun merge(data: Any, left: BinaryTree, right: BinaryTree): BinaryTree {
            val node = BinaryTreeNode(data, left = left.root, right = right.root)
            return BinaryTree(node)
        }
    }

    var root: BinaryTreeNode? = root


    fun insert_left(data: Any, node: BinaryTreeNode? = null): BinaryTreeNode? {
        val new_node = BinaryTreeNode(data)
        if (node == null) {
            if (root != null) return null
            root = new_node
        } else {
            if (node.left != null) return null
            node.left = new_node
        }
        return new_node
    }

    fun insert_right(data: Any, node: BinaryTreeNode? = null): BinaryTreeNode? {
        val new_node = BinaryTreeNode(data)
        if (node == null) {
            if (root != null) return null
            root = new_node
        } else {
            if (node.right != null) return null
            node.right = new_node
        }
        return new_node
    }

    fun remove_left(node: BinaryTreeNode? = null) {
        if (node == null) {
            root = null
        } else {
            node.left = null
        }
    }

    fun remove_right(node: BinaryTreeNode? = null) {
        if (node == null) {
            root = null
        } else {
            node.right = null
        }
    }

}
