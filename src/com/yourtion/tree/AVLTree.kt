package com.yourtion.tree

/**
 * AVLTree
 * Created by Yourtion on 06/06/2017.
 */

/**
 * 自平衡二叉搜索树 AVL Tree
 */
class AVLTree : BinaryTree {

    /**
     * AVL树节点
     */
    internal class AvlNode constructor(
            data: Any,
            var hidden: Boolean = false,
            var height: Int = 0
    ) : BinaryTreeNode(data)

    private val compare: (Any, Any) -> Int

    constructor(compare: (Any, Any) -> Int) {
        this.compare = compare
    }

    /**
     * 获取节点 [node] 高度
     */
    private fun get_height(node: BinaryTreeNode?): Int {
        return if (node == null) -1 else (node as AvlNode).height
    }

    /**
     * 执行左(LL)旋转
     */
    internal fun rotate_left(node: AvlNode): AvlNode {
        val left = node.left as AvlNode
        node.left = left.right
        left.right = node
        node.height = maxOf(get_height(node.left), get_height(node.right)) + 1
        left.height = maxOf(get_height(left.left), node.height) + 1
        return left
    }

    /**
     * 执行右(RR)旋转
     */
    internal fun rotate_right(node: AvlNode): AvlNode {
        val right = node.right as AvlNode
        node.right = right.left
        right.left = node
        node.height = maxOf(get_height(node.left), get_height(node.right)) + 1
        right.height = maxOf(right.height, node.height) + 1
        return right
    }

    /**
     * 执行左右(LR)旋转
     */
    internal fun rotate_left_right(node: AvlNode): AvlNode {
        node.left = rotate_right(node.left as AvlNode)
        return rotate_left(node)
    }

    /**
     * 执行右左(RL)旋转
     */
    internal fun rotate_right_left(node: AvlNode): AvlNode {
        node.right = rotate_left(node.right as AvlNode)
        return rotate_right(node)
    }

    /**
     * 平和节点 [node]
     */
    internal fun balance(node: BinaryTreeNode): AvlNode {
        var res = node as AvlNode
        if (get_height(node.left) - get_height(node.right) > 1) {
            if (get_height(node.left?.left) >= get_height(node.left?.right)) {
                res = rotate_left(node)
            } else {
                res = rotate_left_right(node)
            }
        } else if (get_height(node.right) - get_height(node.left) > 1) {
            if (get_height(node.right?.right) >= get_height(node.right?.left)) {
                res = rotate_right(node)
            } else {
                res = rotate_right_left(node)
            }
        }
        res.height = maxOf(get_height(node.left), get_height(node.right)) + 1
        return res
    }

    /**
     * 在二叉树中插入 [node] 所指定结点
     */
    internal fun _insert(data: Any, node: BinaryTreeNode? = null): AvlNode {
        if (BinaryTree.is_eob(node)) return AvlNode(data)

        val cmpval = compare(data, node!!.data)
        if (cmpval < 0) {
            node.left = _insert(data, node.left)
        } else if (cmpval > 0) {
            node.right = _insert(data, node.right)
        }

        return balance(node)
    }

    /**
     * 在二叉树中移除 [node] 所指定结点
     */
    internal fun _remove(data: Any, node: BinaryTreeNode? = null): AvlNode? {
        if (node == null) return null

        val cmpval = compare(data, node.data)
        if (cmpval < 0) {
            node.left = _remove(data, node.left)
        } else if (cmpval > 0) {
            node.right = _remove(data, node.right)
        } else if (node.left != null && node.right != null) {
            val right = node.right
            node.data = if (right!!.left != null) right.left!!.data else node.data
            node.right = _remove(node.data, node.right)
        } else if (node.left != null) {
            return balance(node.left!!)
        } else if (node.right != null) {
            return balance(node.right!!)
        } else {
            return null
        }

        return balance(node)
    }

    /**
     * 在 [node] 中查找 [data] 所指定数据
     */
    internal fun _lookup(data: Any, node: BinaryTreeNode? = null): AvlNode? {
        if (node == null) return null

        var ret: AvlNode? = node as AvlNode

        val cmpval = compare(data, node.data)
        if (cmpval < 0) {
            ret = _lookup(data, node.left)
        } else if (cmpval > 0) {
            ret = _lookup(data, node.right)
        }

        return ret
    }

    /**
     * 将 [data] 插入二叉搜索树中
     */
    fun insert(data: Any) {
        root = _insert(data, root)
    }

    /**
     * 在二叉搜索树中移除数据 [data] 相吻合的结点
     */
    fun remove(data: Any) {
        root = _remove(data, root)
    }

    /**
     * 判断二叉搜索树中是否存在 [data] 相吻合的结点
     */
    fun lookup(data: Any): Boolean {
        return _lookup(data, root) != null
    }
}
