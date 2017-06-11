package com.yourtion.graph

import org.junit.Assert.*
import org.junit.Test

/**
 * GraphTest
 * Created by Yourtion on 08/06/2017.
 */
class GraphTest {
    @Test
    fun insert_vertex() {
        val graph = Graph<String>()
        assertTrue(graph.insert_vertex("A"))
        assertEquals(graph.vcount, 1)
        assertTrue(graph.insert_vertex("B"))
        assertEquals(graph.vcount, 2)
        assertFalse(graph.insert_vertex("A"))
        assertEquals(graph.vcount, 2)
        assertTrue(graph.insert_vertex("C"))
        assertEquals(graph.vcount, 3)
    }

    @Test
    fun insert_edge() {
        val graph = Graph<String>()
        graph.insert_vertex("A")
        graph.insert_vertex("B")
        graph.insert_vertex("C")
        assertEquals(graph.vcount, 3)
        assertTrue(graph.insert_edge("A", "B"))
        assertTrue(graph.insert_edge("A", "C"))
        assertTrue(graph.insert_edge("C", "B"))
        assertTrue(graph.insert_edge("B", "A"))
        assertEquals(graph.ecount, 4)
        assertFalse(graph.insert_edge("D", "A"))
        assertFalse(graph.insert_edge("A", "D"))
        assertFalse(graph.insert_edge("D", "F"))
        assertFalse(graph.insert_edge("D", "D"))
        assertEquals(graph.ecount, 4)
    }

    fun build_graph() :Graph<String> {
        val graph = Graph<String>()
        graph.insert_vertex("A")
        graph.insert_vertex("B")
        graph.insert_vertex("C")
        graph.insert_vertex("D")
        graph.insert_vertex("E")
        graph.insert_vertex("F")
        graph.insert_edge("A", "B")
        graph.insert_edge("A", "C")
        graph.insert_edge("C", "B")
        graph.insert_edge("B", "A")
        return graph
    }

    @Test
    fun remove_vertex() {
        val graph = build_graph()
        assertEquals(graph.vcount, 6)
        assertTrue(graph.remove_vertex("D"))
        assertTrue(graph.remove_vertex("E"))
        assertTrue(graph.remove_vertex("F"))
        assertEquals(graph.vcount, 3)
        assertFalse(graph.remove_vertex("A"))
        assertFalse(graph.remove_vertex("B"))
        assertFalse(graph.remove_vertex("C"))
        assertFalse(graph.remove_vertex("X"))
        assertEquals(graph.vcount, 3)
    }

    @Test
    fun remove_edge() {
        val graph = build_graph()
        assertEquals(graph.ecount, 4)
        assertTrue(graph.remove_edge("A","B"))
        assertTrue(graph.remove_edge("B","A"))
        assertTrue(graph.remove_edge("C","B"))
        assertEquals(graph.ecount, 1)
        assertFalse(graph.remove_edge("D", "A"))
        assertFalse(graph.remove_edge("X", "B"))
        assertFalse(graph.remove_edge("B", "X"))
        assertEquals(graph.ecount, 1)
    }

    @Test
    fun get_adjlist() {
        val graph = build_graph()
        val a = graph.get_adjlist("A")
        assertNotNull(a)
        assertEquals(a!!.adjacent.size, 2)
        val d = graph.get_adjlist("D")
        assertNotNull(d)
        assertEquals(d!!.adjacent.size, 0)
        assertNull(graph.get_adjlist("X"))
    }

    @Test
    fun is_adjacent() {
        val graph = build_graph()
        assertTrue(graph.is_adjacent("A","B"))
        assertTrue(graph.is_adjacent("B","A"))
        assertTrue(graph.is_adjacent("C","B"))
        assertFalse(graph.is_adjacent("D", "A"))
        assertFalse(graph.is_adjacent("X", "B"))
        assertFalse(graph.is_adjacent("B", "X"))
    }

    @Test
    fun example() {
        val graph = Graph<String>()
        println("Inserting vertex a, b, c, d, e")
        graph.insert_vertex("a")
        graph.insert_vertex("b")
        graph.insert_vertex("c")
        graph.insert_vertex("d")
        graph.insert_vertex("e")
        assertEquals(graph.vcount, 5)

        println("Inserting edges")
        graph.insert_edge("a", "b")
        graph.insert_edge("a", "c")
        graph.insert_edge("b", "c")
        graph.insert_edge("b", "d")
        graph.insert_edge("c", "b")
        graph.insert_edge("c", "c")
        graph.insert_edge("c", "d")
        graph.insert_edge("d", "a")
        graph.insert_edge("e", "c")
        graph.insert_edge("e", "d")
        assertEquals(graph.ecount, 10)

        println("Removing edges")
        graph.remove_edge("a", "c")
        graph.remove_edge("c", "c")
        graph.remove_edge("e", "c")
        graph.remove_edge("a", "b")
        graph.remove_edge("d", "a")
        assertEquals(graph.vcount, 5)
        assertEquals(graph.ecount, 5)
        assertTrue(graph.remove_vertex("a"))

        println("Inserting edges again")
        assertFalse(graph.insert_edge("f", "a"))
        assertTrue(graph.insert_edge("c", "b"))
        assertFalse(graph.insert_edge("f", "a"))
        assertFalse(graph.remove_edge("c", "e"))
        assertFalse(graph.insert_vertex("c"))
        assertEquals(graph.vcount, 4)
        assertEquals(graph.ecount, 6)

        println("Testing is_adjacent")
        assertTrue(graph.is_adjacent("b", "d"))
        assertFalse(graph.is_adjacent("a", "e"))
        assertTrue(graph.is_adjacent("e", "d"))
        assertFalse(graph.is_adjacent("c", "a"))

        println("Testing get_adjlist")
        val c = graph.get_adjlist("c")
        assertEquals(c!!.adjacent.size, 2)
    }

}
