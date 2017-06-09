package com.yourtion.tree

/**
 * BinaryTree
 * Created by Yourtion on 06/06/2017.
 */

/**
 * 二叉树
 */
open class BinaryTree constructor(root: BinaryTreeNode? = null) {

    /**
     * 二叉树节点
     */
    open class BinaryTreeNode constructor(
            var data: Any,
            var left: BinaryTreeNode? = null,
            var right: BinaryTreeNode? = null
    )

    companion object {

        /**
         * 判断 [node] 所标识结点是否为二叉树中某个分支的结束
         */
        fun is_eob(node: BinaryTreeNode?): Boolean {
            return node == null
        }

        /**
         * 判断 [node] 所指定结点是否为二叉树中的叶子结点
         */
        fun is_leaf(node: BinaryTreeNode): Boolean {
            return node.left == null && node.right == null
        }

        /**
         * 将 [left] 和 [right] 所指定的两棵二叉树合并为单棵二叉树，根为 [data]
         */
        fun merge(data: Any, left: BinaryTree, right: BinaryTree): BinaryTree {
            val node = BinaryTreeNode(data, left = left.root, right = right.root)
            return BinaryTree(node)
        }
    }

    // 根节点
    var root: BinaryTreeNode? = root
        protected set

    /**
     * 在二叉树中插入一个 [node] 所指定结点的左子结点 [data]
     */
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

    /**
     * 在二叉树中插入一个 [node] 所指定结点的右子结点 [data]
     */
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

    /**
     * 移除二叉树中 [node] 的左子结点为根的子树
     */
    fun remove_left(node: BinaryTreeNode? = null) {
        if (node == null) {
            root = null
        } else {
            node.left = null
        }
    }

    /**
     * 移除二叉树中 [node] 的右子结点为根的子树
     */
    fun remove_right(node: BinaryTreeNode? = null) {
        if (node == null) {
            root = null
        } else {
            node.right = null
        }
    }

}
