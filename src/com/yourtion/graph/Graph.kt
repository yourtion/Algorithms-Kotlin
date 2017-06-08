package com.yourtion.graph

import com.yourtion.list.List
import com.yourtion.set.Set

/**
 * Graph
 * Created by Yourtion on 08/06/2017.
 */

/**
 *
 */
data class AdjList constructor(val vertex: Any, val adjacent: Set = Set())

enum class VertexColor { White, Gray, Black }

/**
 *
 */
class Graph {
    private var _vcount = 0
    private var _ecount = 0
    private val _adjlists = List()

    val vcount: Int get() {
        return _vcount
    }
    val ecount: Int get() {
        return _ecount
    }
    val adjlists: List get() {
        return _adjlists
    }

    private fun match(element: List.ListElmt, data: Any): Boolean {
        return (element.data as AdjList).vertex == data
    }

    fun insert_vertex(data: Any): Boolean {
        var element = _adjlists.head
        while (element != null) {
            if (match(element, data)) return false
            element = element.next
        }

        val adjlist = AdjList(data)
        adjlists.insert_next(adjlist, adjlists.tail)
        _vcount++
        return true
    }

    fun insert_edge(data1: Any, data2: Any): Boolean {
        var element = _adjlists.head
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
        _ecount++
        return true
    }

    fun remove_vertex(data: Any): Boolean {
        var element = _adjlists.head
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
        _adjlists.remove_next(prev)
        _vcount--
        return true
    }

    fun remove_edge(data1: Any, data2: Any): Boolean {
        var element = _adjlists.head
        while (element != null) {
            if (match(element, data1)) break
            element = element.next
        }
        if (element == null) return false
        val ret = (element.data as AdjList).adjacent.remove(data2)
        if (ret) _ecount--
        return ret
    }

    fun get_adjlist(data: Any): AdjList? {
        var element = _adjlists.head
        while (element != null) {
            if (match(element, data)) return element.data as AdjList
            element = element.next
        }
        return null
    }

    fun is_adjacent(data1: Any, data2: Any): Boolean {
        var element = _adjlists.head
        while (element != null) {
            if (match(element, data1)) {
                return (element.data as AdjList).adjacent.is_member(data2)
            }
            element = element.next
        }
        return false
    }
}
