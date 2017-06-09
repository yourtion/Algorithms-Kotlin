package com.yourtion.graph

import org.junit.Assert.*
import org.junit.Test

/**
 * GraphDFSKtTest
 * Created by Yourtion on 08/06/2017.
 */
class GraphDFSKtTest {
    @Test
    fun dfs() {
        val graph = Graph()
        val a = DFSVertex("a")
        val b = DFSVertex("b")
        val c = DFSVertex("c")
        val d = DFSVertex("d")
        graph.insert_vertex(a)
        graph.insert_vertex(b)
        graph.insert_vertex(c)
        graph.insert_vertex(d)
        graph.insert_edge(a, b)
        graph.insert_edge(a, c)
        graph.insert_edge(a, d)
        val list = graph.dfs()
        assertEquals(list.size, 4)
    }
}
