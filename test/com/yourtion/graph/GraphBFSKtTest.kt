package com.yourtion.graph

import com.yourtion.list.List
import org.junit.Assert.assertEquals
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

    fun verify(list: List, order: Array<BFSVertex>) {
        var element = list.head
        for (i in IntRange(0, list.size - 1)) {
            assertEquals(element!!.data, order[i])
            element = element.next
        }
    }

    @Test
    fun example() {
        val graph = Graph()
        println("Inserting vertex node1...node6")
        val n1 = BFSVertex("node1")
        val n2 = BFSVertex("node2")
        val n3 = BFSVertex("node3")
        val n4 = BFSVertex("node4")
        val n5 = BFSVertex("node5")
        val n6 = BFSVertex("node6")
        graph.insert_vertex(n1)
        graph.insert_vertex(n2)
        graph.insert_vertex(n3)
        graph.insert_vertex(n4)
        graph.insert_vertex(n5)
        graph.insert_vertex(n6)
        assertEquals(graph.vcount, 6)

        println("Inserting edges")
        graph.insert_edge(n1, n2)
        graph.insert_edge(n2, n1)
        graph.insert_edge(n1, n3)
        graph.insert_edge(n3, n1)
        graph.insert_edge(n2, n3)
        graph.insert_edge(n3, n2)
        graph.insert_edge(n2, n4)
        graph.insert_edge(n4, n2)
        graph.insert_edge(n5, n3)
        graph.insert_edge(n3, n5)
        graph.insert_edge(n4, n5)
        graph.insert_edge(n5, n4)
        graph.insert_edge(n6, n5)
        graph.insert_edge(n5, n6)
        assertEquals(graph.ecount, 14)

        println("Generating the breadth-first search listing")
        val list = graph.bfs(n1)
        assertEquals(list!!.size, 6)
        val n1v = BFSVertex("node1", color = VertexColor.Black, hops = 0)
        val n2v = BFSVertex("node2", color = VertexColor.Black, hops = 1)
        val n3v = BFSVertex("node3", color = VertexColor.Black, hops = 1)
        val n4v = BFSVertex("node4", color = VertexColor.Black, hops = 2)
        val n5v = BFSVertex("node5", color = VertexColor.Black, hops = 2)
        val n6v = BFSVertex("node6", color = VertexColor.Black, hops = 3)
        verify(list, arrayOf(n1v, n2v, n3v, n4v, n5v, n6v))
    }

}
