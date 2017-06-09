package com.yourtion.graph

import com.yourtion.list.List
import com.yourtion.list.Queue

/**
 * Graph breadth-first search
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 广度搜索结点
 */
data class BFSVertex(
        val data: Any,
        var color: VertexColor = VertexColor.White,
        var hops: Int = -1
)

/**
 * 从 start 开始对图执行广度搜索
 */
fun Graph.bfs(start: BFSVertex): List? {
    var element = adjlists.head
    var clr_vertex: BFSVertex?
    while (element != null) {
        clr_vertex = (element.data as AdjList).vertex as BFSVertex
        if (clr_vertex.data == start.data) {
            clr_vertex.color = VertexColor.Gray
            clr_vertex.hops = 0
        } else {
            clr_vertex.color = VertexColor.White
            clr_vertex.hops = -1
        }
        element = element.next
    }

    val queue = Queue()
    var clr_adjlist = get_adjlist(start) ?: return null
    queue.enqueue(clr_adjlist)

    var adjlist: AdjList
    var adj_vertex: BFSVertex?
    while (queue.size > 0) {

        adjlist = queue.peek() as AdjList

        element = adjlist.adjacent.head
        while (element != null) {
            adj_vertex = element.data as BFSVertex
            clr_adjlist = get_adjlist(adj_vertex) ?: return null
            clr_vertex = clr_adjlist.vertex as BFSVertex

            if (clr_vertex.color == VertexColor.White) {
                clr_vertex.color = VertexColor.Gray
                clr_vertex.hops = (adjlist.vertex as BFSVertex).hops + 1
                queue.enqueue(clr_adjlist)
            }
            element = element.next
        }

        adjlist = queue.dequeue() as AdjList
        (adjlist.vertex as BFSVertex).color = VertexColor.Black
    }
    
    val list = List()
    element = adjlists.head
    while (element != null) {
        clr_vertex = (element.data as AdjList).vertex as BFSVertex
        if (clr_vertex.hops != -1) {
            list.insert_next(clr_vertex, list.tail)
        }
        element = element.next
    }

    return list
}

