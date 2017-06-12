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
data class AdjList<E> constructor(val vertex: E, val adjacent: Set<E> = Set<E>())

/**
 * 顶点颜色
 */
enum class VertexColor { White, Gray, Black }

/**
 * 图
 */
class Graph<E> {

    var vcount = 0
        private set
    var ecount = 0
        private set
    val adjlists = List<AdjList<E>>()

    /**
     * 将顶点 [data] 插入图中
     */
    fun insert_vertex(data: E): Boolean {
        adjlists
                .filter { it.vertex == data }
                .forEach { return false }
        adjlists.insert_next(AdjList(data), adjlists.tail)
        vcount++
        return true
    }

    /**
     * 将由 [data1] 以及 [data2] 所指定的顶点构成的边插入图中
     */
    fun insert_edge(data1: E, data2: E): Boolean {
        var count = 0
        var node: AdjList<E>? = null
        for (item in adjlists) {
            if (item.vertex == data1) {
                node = item
                count++
            }
            if (item.vertex == data2) count++
        }
        if (count != 2 || node == null) return false
        node.adjacent.insert(data2)
        ecount++
        return true
    }

    /**
     * 从图中移除与 [data] 相匹配的顶点
     */
    fun remove_vertex(data: E): Boolean {
        val adjlists_it = adjlists.iterator()
        for (item in adjlists_it) {
            if (item.adjacent.is_member(data)) return false
            if (item.vertex == data) {
                if (item.adjacent.size > 0) return false
                adjlists_it.remove()
                vcount--
                return true
            }
        }
        return false
    }

    /**
     * 从图中移除从 [data1] 到 [data2] 的边
     */
    fun remove_edge(data1: E, data2: E): Boolean {
        val element = adjlists.firstOrNull { it.vertex == data1 } ?: return false
        val ret = element.adjacent.remove(data2)
        if (ret) ecount--
        return ret
    }

    /**
     * 取出图中由 [data] 所指定的顶点的邻接表
     */
    fun get_adjlist(data: E): AdjList<E>? {
        return adjlists.firstOrNull { it.vertex == data }
    }

    /**
     * 判断由 [data2] 所指定的顶点是否与图中由 [data1] 所指定的顶点邻接
     */
    fun is_adjacent(data1: E, data2: E): Boolean {
        return adjlists
                .firstOrNull { it.vertex == data1 }
                ?.let { it.adjacent.is_member(data2) }
                ?: false
    }
}
