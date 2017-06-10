package com.yourtion.heap

/**
 * Heap
 * Created by Yourtion on 07/06/2017.
 */

/**
 * 堆
 */
open class Heap<E> constructor(compare: (E, E) -> Int) {

    private val compare: (E, E) -> Int = compare
    private var tree: MutableList<E> = mutableListOf()
    val size: Int
        get() = tree.size

    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    /**
     * 获取父结点位置 (i-1)/2
     */
    private val parent = { pos: Int -> (pos - 1) / 2 }

    /**
     * 获取左子结点位置 i*2+1
     */
    private val left = { pos: Int -> pos * 2 + 1 }

    /**
     * 获取右子结点位置 i*2+2
     */
    private val right = { pos: Int -> pos * 2 + 2 }

    /**
     * 向堆中插入一个结点 [data]
     */
    fun insert(data: E) {
        var ipos = size
        var ppos = parent(ipos)
        tree.add(element = data)

        // 通过将节点上推保障树的平衡
        while (ipos > 0 && compare(tree[ppos], tree[ipos]) < 0) {
            tree.swap(ppos, ipos)
            ipos = ppos
            ppos = parent(ipos)
        }
    }

    /**
     * 从堆中释放堆顶部的结点
     */
    fun extract(): E? {
        if (size < 1) return null
        val data = tree.removeAt(0)
        if (size == 0) return data

        // 通过将顶部节点下移保障树的平衡

        var ipos = 0
        var lpos: Int
        var rpos: Int
        var mpos: Int

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

            // 当 mpos 就是 ipos 时，堆已经完成调整
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
