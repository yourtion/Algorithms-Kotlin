package com.yourtion.graph

import com.yourtion.list.List
import com.yourtion.set.Set

/**
 * Graph
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 邻接表
 */
data class AdjList constructor(val vertex: Any, val adjacent: Set = Set())

/**
 * 顶点颜色
 */
enum class VertexColor { White, Gray, Black }

/**
 * 图
 */
class Graph {

    var vcount = 0
        private set
    var ecount = 0
        private set
    val adjlists = List()

    /**
     * 匹配节点元素
     */
    private fun match(element: List.ListElmt, data: Any): Boolean {
        return (element.data as AdjList).vertex == data
    }

    /**
     * 将顶点 [data] 插入图中
     */
    fun insert_vertex(data: Any): Boolean {
        var element = adjlists.head
        while (element != null) {
            if (match(element, data)) return false
            element = element.next
        }

        val adjlist = AdjList(data)
        adjlists.insert_next(adjlist, adjlists.tail)
        vcount++
        return true
    }

    /**
     * 将由 [data1] 以及 [data2] 所指定的顶点构成的边插入图中
     */
    fun insert_edge(data1: Any, data2: Any): Boolean {
        var element = adjlists.head
        var count = 0
        var node: List.ListElmt? = null
        while (element != null) {
            if (match(element, data1)) {
                node = element
                count++
            }
            if (match(element, data2)) count++
            element = element.next
        }
        if (count != 2 || node == null) return false
        (node.data as AdjList).adjacent.insert(data2)
        ecount++
        return true
    }

    /**
     * 从图中移除与 [data] 相匹配的顶点
     */
    fun remove_vertex(data: Any): Boolean {
        var element = adjlists.head
        var prev: List.ListElmt? = null
        var found = false
        while (element != null) {
            if ((element.data as AdjList).adjacent.is_member(data)) return false
            if (match(element, data)) {
                if ((element.data as AdjList).adjacent.size > 0) return false
                found = true
            }
            if (!found) prev = element
            element = element.next
        }
        if (!found) return false
        adjlists.remove_next(prev)
        vcount--
        return true
    }

    /**
     * 从图中移除从 [data1] 到 [data2] 的边
     */
    fun remove_edge(data1: Any, data2: Any): Boolean {
        var element = adjlists.head
        while (element != null) {
            if (match(element, data1)) break
            element = element.next
        }
        if (element == null) return false
        val ret = (element.data as AdjList).adjacent.remove(data2)
        if (ret) ecount--
        return ret
    }

    /**
     * 取出图中由 [data] 所指定的顶点的邻接表
     */
    fun get_adjlist(data: Any): AdjList? {
        var element = adjlists.head
        while (element != null) {
            if (match(element, data)) return element.data as AdjList
            element = element.next
        }
        return null
    }

    /**
     * 判断由 [data2] 所指定的顶点是否与图中由 [data1] 所指定的顶点邻接
     */
    fun is_adjacent(data1: Any, data2: Any): Boolean {
        var element = adjlists.head
        while (element != null) {
            if (match(element, data1)) {
                return (element.data as AdjList).adjacent.is_member(data2)
            }
            element = element.next
        }
        return false
    }
}
