package com.yourtion.tree

import com.yourtion.list.List

/**
 * Created by Yourtion on 06/06/2017.
 */

enum class TraverseOrder { PreOrder, InOrder, PostOrder }

/**
 * 根据 [order] 顺序遍历二叉树
 */
fun BinaryTree.order(order: TraverseOrder): List {
    when (order) {
        TraverseOrder.PreOrder -> return pre_order()
        TraverseOrder.InOrder -> return in_order()
        TraverseOrder.PostOrder -> return post_order()
    }
}

/**
 * 前序方式来遍历二叉树
 */
fun BinaryTree.pre_order(node: BinaryTree.BinaryTreeNode = root!!, list: List = List()): List {
    if (!BinaryTree.is_eob(node)) {
        list.insert_next(node.data, list.tail)

        if (!BinaryTree.is_eob(node.left)) {
            pre_order(node = node.left!!, list = list)
        }

        if (!BinaryTree.is_eob(node.right)) {
            pre_order(node = node.right!!, list = list)
        }
    }
    return list
}

/**
 * 中序方式来遍历二叉树
 */
fun BinaryTree.in_order(node: BinaryTree.BinaryTreeNode = root!!, list: List = List()): List {
    if (!BinaryTree.is_eob(node)) {

        if (!BinaryTree.is_eob(node.left)) {
            in_order(node = node.left!!, list = list)
        }

        list.insert_next(node.data, list.tail)

        if (!BinaryTree.is_eob(node.right)) {
            in_order(node = node.right!!, list = list)
        }
    }
    return list
}

/**
 * 后序方式来遍历二叉树
 */
fun BinaryTree.post_order(node: BinaryTree.BinaryTreeNode = root!!, list: List = List()): List {
    if (!BinaryTree.is_eob(node)) {

        if (!BinaryTree.is_eob(node.left)) {
            post_order(node = node.left!!, list = list)
        }

        if (!BinaryTree.is_eob(node.right)) {
            post_order(node = node.right!!, list = list)
        }

        list.insert_next(node.data, list.tail)
    }
    return list
}
