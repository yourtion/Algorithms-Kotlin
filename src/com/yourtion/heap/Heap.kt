package com.yourtion.heap

/**
 * Heap
 * Created by Yourtion on 07/06/2017.
 */
class Heap constructor(compare: (Any, Any) -> Int) {

    private val compare: (Any, Any) -> Int = compare
    private var tree: MutableList<Any> = MutableList(0, {})
    val size: Int
        get() = tree.size

    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    private fun parent(pos: Int): Int {
        return (pos - 1) / 2
    }

    private fun left(pos: Int): Int {
        return pos * 2 + 1
    }

    private fun right(pos: Int): Int {
        return pos * 2 + 2
    }

    fun insert(data: Any) {
        var ipos = size
        var ppos = parent(ipos)
        tree.add(element = data)
        while (ipos > 0 && compare(tree[ppos], tree[ipos]) < 0) {
            tree.swap(ppos, ipos)
            ipos = ppos
            ppos = parent(ipos)
        }
    }

    fun extract(): Any? {
        if (size < 1) return null
        val data = tree.removeAt(0)
        if (size == 0) return data

        var ipos = 0
        var lpos : Int
        var rpos : Int
        var mpos : Int

        while (true) {
            lpos = left(ipos)
            rpos = right(ipos)

            if (lpos < size && compare(tree[lpos], tree[ipos]) > 0) {
                mpos = lpos
            } else {
                mpos = ipos
            }

            if (rpos < size && compare(tree[rpos], tree[mpos]) > 0) {
                mpos = rpos
            }

            if (mpos == ipos) {
                break
            } else {
                tree.swap(mpos, ipos)
                ipos = mpos
            }
        }
        return data
    }
}