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
    var element = adjlists.head
    var clr_vertex: BFSVertex<E>?
    while (element != null) {
        clr_vertex = element.data.vertex
        if (clr_vertex.data == start.data) {
            clr_vertex.color = VertexColor.Gray
            clr_vertex.hops = 0
        } else {
            clr_vertex.color = VertexColor.White
            clr_vertex.hops = -1
        }
        element = element.next
    }

    val queue = Queue<AdjList<BFSVertex<E>>>()
    var clr_adjlist = get_adjlist(start) ?: return null
    queue.enqueue(clr_adjlist)

    var adjlist: AdjList<BFSVertex<E>>?
    var adj_vertex: BFSVertex<E>?
    var element_temp : List.ListElmt<BFSVertex<E>>?
    while (queue.size > 0) {

        adjlist = queue.peek()

        element_temp = adjlist!!.adjacent.head
        while (element_temp != null) {
            adj_vertex = element_temp.data
            clr_adjlist = get_adjlist(adj_vertex) ?: return null
            clr_vertex = clr_adjlist.vertex

            if (clr_vertex.color == VertexColor.White) {
                clr_vertex.color = VertexColor.Gray
                clr_vertex.hops = adjlist.vertex.hops + 1
                queue.enqueue(clr_adjlist)
            }
            element_temp = element_temp.next
        }

        adjlist = queue.dequeue()
        adjlist!!.vertex.color = VertexColor.Black
    }
    
    val list = List<BFSVertex<E>>()
    element = adjlists.head
    while (element != null) {
        clr_vertex = element.data.vertex
        if (clr_vertex.hops != -1) {
            list.insert_next(clr_vertex, list.tail)
        }
        element = element.next
    }

    return list
}

