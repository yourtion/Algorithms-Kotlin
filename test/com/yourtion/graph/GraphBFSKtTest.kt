package com.yourtion.graph

import org.junit.Assert.*
import org.junit.Test

/**
 * GraphBFSKtTest
 * Created by Yourtion on 08/06/2017.
 */
class GraphBFSKtTest {
    @Test
    fun bfs() {
        val graph = Graph()
        val a = BFSVertex("a")
        val b = BFSVertex("b")
        val c = BFSVertex("c")
        val d = BFSVertex("d")
        graph.insert_vertex(a)
        graph.insert_vertex(b)
        graph.insert_vertex(c)
        graph.insert_vertex(d)
        graph.insert_edge(a, b)
        graph.insert_edge(a, c)
        graph.insert_edge(a, d)

        var list = graph.bfs(a)
        assertEquals(list!!.size, 4)

        list = graph.bfs(b)
        assertEquals(list!!.size, 1)

        graph.insert_edge(b, a)
        list = graph.bfs(b)
        assertEquals(list!!.size, 4)
    }

}