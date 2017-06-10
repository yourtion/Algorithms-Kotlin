package com.yourtion.tree

/**
 * Binary Tree
 * Created by Yourtion on 06/06/2017.
 */

/**
 * 二叉树
 */
open class BinaryTree<E> constructor(root: BinaryTreeNode<E>? = null) {

    /**
     * 二叉树节点
     */
    open class BinaryTreeNode<E> constructor(
            var data: E,
            var left: BinaryTreeNode<E>? = null,
            var right: BinaryTreeNode<E>? = null
    )

    companion object {

        /**
         * 判断 [node] 所指定结点是否为二叉树中的叶子结点
         */
        fun <E> is_leaf(node: BinaryTreeNode<E>): Boolean {
            return node.left == null && node.right == null
        }

        /**
         * 将 [left] 和 [right] 所指定的两棵二叉树合并为单棵二叉树，根为 [data]
         */
        fun <E> merge(data: E, left: BinaryTree<E>, right: BinaryTree<E>): BinaryTree<E> {
            val node = BinaryTreeNode(data, left = left.root, right = right.root)
            return BinaryTree(node)
        }
    }

    // 根节点
    var root: BinaryTreeNode<E>? = root
        protected set

    /**
     * 在二叉树中插入一个 [node] 所指定结点的左子结点 [data]
     */
    fun insert_left(data: E, node: BinaryTreeNode<E>? = null): BinaryTreeNode<E>? {
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

    /**
     * 在二叉树中插入一个 [node] 所指定结点的右子结点 [data]
     */
    fun insert_right(data: E, node: BinaryTreeNode<E>? = null): BinaryTreeNode<E>? {
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

    /**
     * 移除二叉树中 [node] 的左子结点为根的子树
     */
    fun remove_left(node: BinaryTreeNode<E>? = null) {
        if (node == null) {
            root = null
        } else {
            node.left = null
        }
    }

    /**
     * 移除二叉树中 [node] 的右子结点为根的子树
     */
    fun remove_right(node: BinaryTreeNode<E>? = null) {
        if (node == null) {
            root = null
        } else {
            node.right = null
        }
    }

}
