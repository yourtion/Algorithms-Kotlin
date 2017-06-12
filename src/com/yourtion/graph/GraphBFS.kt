package com.yourtion.graph

import com.yourtion.list.List
import com.yourtion.stack.Queue

/**
 * Graph breadth-first search
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 广度搜索结点
 */
data class BFSVertex<E>(
        val data: E,
        var color: VertexColor = VertexColor.White,
        var hops: Int = -1
)

/**
 * 从 start 开始对图执行广度搜索
 */
fun <E> Graph<BFSVertex<E>>.bfs(start: BFSVertex<E>): List<BFSVertex<E>>? {
    var clr_vertex: BFSVertex<E>?
    for ((vertex) in adjlists) {
        clr_vertex = vertex
        if (clr_vertex.data == start.data) {
            clr_vertex.color = VertexColor.Gray
            clr_vertex.hops = 0
        } else {
            clr_vertex.color = VertexColor.White
            clr_vertex.hops = -1
        }
    }

    val queue = Queue<AdjList<BFSVertex<E>>>()
    var clr_adjlist = get_adjlist(start) ?: return null
    queue.enqueue(clr_adjlist)

    var adjlist: AdjList<BFSVertex<E>>?
    while (queue.size > 0) {

        adjlist = queue.peek()

        for (element in adjlist!!.adjacent) {
            clr_adjlist = get_adjlist(element) ?: return null
            clr_vertex = clr_adjlist.vertex

            if (clr_vertex.color == VertexColor.White) {
                clr_vertex.color = VertexColor.Gray
                clr_vertex.hops = adjlist.vertex.hops + 1
                queue.enqueue(clr_adjlist)
            }
        }

        adjlist = queue.dequeue()
        adjlist!!.vertex.color = VertexColor.Black
    }

    val list = List<BFSVertex<E>>()
    adjlists
            .filter { it.vertex.hops != -1 }
            .forEach { (vertex) ->
                list.insert_next(vertex, list.tail)
            }

    return list
}
