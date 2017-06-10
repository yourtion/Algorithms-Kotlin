package com.yourtion.tree

import com.yourtion.list.List

/**
 * BinaryTree Traverse
 * Created by Yourtion on 06/06/2017.
 */

enum class TraverseOrder { PreOrder, InOrder, PostOrder }

/**
 * 根据 [order] 顺序遍历二叉树
 */
fun <E> BinaryTree<E>.order(order: TraverseOrder): List<E> {
    when (order) {
        TraverseOrder.PreOrder -> return pre_order()
        TraverseOrder.InOrder -> return in_order()
        TraverseOrder.PostOrder -> return post_order()
    }
}

/**
 * 前序方式来遍历二叉树
 */
fun <E> BinaryTree<E>.pre_order(node: BinaryTree.BinaryTreeNode<E>? = root!!, list: List<E> = List<E>()): List<E> {
    if (node != null) {
        list.insert_next(node.data, list.tail)

        if (node.left != null) {
            pre_order(node = node.left!!, list = list)
        }

        if (node.right != null) {
            pre_order(node = node.right!!, list = list)
        }
    }
    return list
}

/**
 * 中序方式来遍历二叉树
 */
fun <E> BinaryTree<E>.in_order(node: BinaryTree.BinaryTreeNode<E>? = root!!, list: List<E> = List<E>()): List<E>  {
    if (node != null) {

        if (node.left != null) {
            in_order(node = node.left!!, list = list)
        }

        list.insert_next(node.data, list.tail)

        if (node.right != null) {
            in_order(node = node.right!!, list = list)
        }
    }
    return list
}

/**
 * 后序方式来遍历二叉树
 */
fun <E> BinaryTree<E>.post_order(node: BinaryTree.BinaryTreeNode<E>? = root!!, list: List<E> = List<E>()): List<E>  {
    if (node != null) {

        if (node.left != null) {
            post_order(node = node.left!!, list = list)
        }

        if (node.right != null) {
            post_order(node = node.right!!, list = list)
        }

        list.insert_next(node.data, list.tail)
    }
    return list
}
