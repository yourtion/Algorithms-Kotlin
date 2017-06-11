package com.yourtion.graph

import com.yourtion.list.List
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * GraphDFSKtTest
 * Created by Yourtion on 08/06/2017.
 */
class GraphDFSKtTest {
    @Test
    fun dfs() {
        val graph = Graph<DFSVertex<String>>()
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

    fun verify(list: List<DFSVertex<String>>, order: Array<String>) {
        var element = list.head
        for (i in IntRange(0, list.size - 1)) {
            val e = element!!.data
            assertEquals(e.data, order[i])
            assertEquals(e.color, VertexColor.Black)
            element = element.next
        }
    }

    @Test
    fun example() {
        val graph = Graph<DFSVertex<String>>()
        println("Inserting vertex a...i")
        val a = DFSVertex("a")
        val b = DFSVertex("b")
        val c = DFSVertex("c")
        val d = DFSVertex("d")
        val e = DFSVertex("e")
        val f = DFSVertex("f")
        val g = DFSVertex("g")
        val h = DFSVertex("h")
        val i = DFSVertex("i")
        graph.insert_vertex(a)
        graph.insert_vertex(b)
        graph.insert_vertex(c)
        graph.insert_vertex(d)
        graph.insert_vertex(e)
        graph.insert_vertex(e)
        graph.insert_vertex(f)
        graph.insert_vertex(g)
        graph.insert_vertex(h)
        graph.insert_vertex(i)
        assertEquals(graph.vcount, 9)

        println("Inserting edges")
        graph.insert_edge(a, b)
        graph.insert_edge(a, c)
        graph.insert_edge(b, i)
        graph.insert_edge(c, i)
        graph.insert_edge(e, f)
        graph.insert_edge(e, h)
        graph.insert_edge(f, c)
        graph.insert_edge(f, h)
        graph.insert_edge(g, h)
        assertEquals(graph.ecount, 9)

        println("Generating the breadth-first search listing")
        val list = graph.dfs()
        assertEquals(list.size, 9)
        verify(list, arrayOf("g", "e", "f", "h", "d", "a", "c", "b", "i"))
    }
}
