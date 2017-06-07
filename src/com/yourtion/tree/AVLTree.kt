package com.yourtion.tree

/**
 * Created by Yourtion on 06/06/2017.
 */
/**
 * 二叉搜索树
 */
class AVLTree : BinaryTree {

    internal class AvlNode constructor(
            data: Any,
            var hidden: Boolean = false,
            var height: Int = 0
    ) : BinaryTreeNode(data)

    private val compare: (Any, Any) -> Int

    constructor(compare: (Any, Any) -> Int) {
        this.compare = compare
    }

    private fun get_height(node: BinaryTreeNode?): Int {
        return if (node == null) -1 else (node as AvlNode).height
    }

    internal fun rotate_left(node: AvlNode): AvlNode {
        val left = node.left as AvlNode
        node.left = left.right
        left.right = node
        node.height = maxOf(get_height(node.left), get_height(node.right)) + 1
        left.height = maxOf(get_height(left.left), node.height) + 1
        return left
    }

    internal fun rotate_right(node: AvlNode): AvlNode {
        val right = node.right as AvlNode
        node.right = right.left
        right.left = node
        node.height = maxOf(get_height(node.left), get_height(node.right)) + 1
        right.height = maxOf(right.height, node.height) + 1
        return right
    }

    internal fun rotate_left_right(node: AvlNode): AvlNode {
        node.left = rotate_right(node.left as AvlNode)
        return rotate_left(node)
    }

    internal fun rotate_right_left(node: AvlNode): AvlNode {
        node.right = rotate_left(node.right as AvlNode)
        return rotate_right(node)
    }

    internal fun balance(node: AvlNode): AvlNode {
        var res = node
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

    internal fun _insert(data: Any, node: BinaryTreeNode? = null): AvlNode {
        if (BinaryTree.is_eob(node)) return AvlNode(data)

        val cmpval = compare(data, node!!.data)
        if (cmpval < 0) {
            node.left = _insert(data, node.left)
        } else if (cmpval > 0) {
            node.right = _insert(data, node.right)
        }

        return balance(node as AvlNode)
    }

    fun insert(data: Any) {
        root = _insert(data, root)
    }

    fun remove() {

    }

    fun lookup() {

    }
}
