package com.yourtion.graph

import com.yourtion.list.List

/**
 * Graph depth-first search
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 广度搜索结点
 */
data class DFSVertex<E>(val data: E, var color: VertexColor = VertexColor.White)

/**
 * 广度搜索主函数
 */
internal fun <E> Graph<DFSVertex<E>>.dfs_main(adjlist: AdjList<DFSVertex<E>>, ordered: List<DFSVertex<E>>) {
    adjlist.vertex.color = VertexColor.Gray

    var element = adjlist.adjacent.head
    var adj_vertex: DFSVertex<E>
    var clr_vertex: DFSVertex<E>
    var clr_adjlist: AdjList<DFSVertex<E>>?
    while (element != null) {
        adj_vertex = element.data
        clr_adjlist = get_adjlist(adj_vertex)
        clr_vertex = clr_adjlist!!.vertex

        if (clr_vertex.color == VertexColor.White) {
            dfs_main(clr_adjlist, ordered)
        }
        element = element.next
    }

    adjlist.vertex.color = VertexColor.Black

    ordered.insert_next(adjlist.vertex)
}

/**
 * 广度搜索
 */
fun <E> Graph<DFSVertex<E>>.dfs(): List<DFSVertex<E>> {
    var element = adjlists.head
    var vertex: DFSVertex<E>?
    while (element != null) {
        element.data.vertex.color = VertexColor.White
        element = element.next
    }

    val list = List<DFSVertex<E>>()
    element = adjlists.head
    while (element != null) {
        vertex = element.data.vertex
        if (vertex.color == VertexColor.White) {
            dfs_main(element.data, list)
        }
        element = element.next
    }

    return list
}
