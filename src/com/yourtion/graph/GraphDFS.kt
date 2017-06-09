package com.yourtion.graph

import com.yourtion.list.List

/**
 * Graph depth-first search
 * Created by Yourtion on 08/06/2017.
 */

/**
 * 广度搜索结点
 */
data class DFSVertex(val data: Any, var color: VertexColor = VertexColor.White)

/**
 * 广度搜索主函数
 */
internal fun Graph.dfs_main(adjlist: AdjList, ordered: List) {
    (adjlist.vertex as DFSVertex).color = VertexColor.Gray

    var element = adjlist.adjacent.head
    var adj_vertex: DFSVertex
    var clr_vertex: DFSVertex
    var clr_adjlist: AdjList?
    while (element != null) {
        adj_vertex = element.data as DFSVertex
        clr_adjlist = get_adjlist(adj_vertex)
        clr_vertex = clr_adjlist!!.vertex as DFSVertex

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
fun Graph.dfs(): List {
    var element = adjlists.head
    var vertex: DFSVertex?
    while (element != null) {
        ((element.data as AdjList).vertex as DFSVertex).color = VertexColor.White
        element = element.next
    }

    val list = List()
    element = adjlists.head
    while (element != null) {
        vertex = ((element.data as AdjList).vertex as DFSVertex)
        if (vertex.color == VertexColor.White) {
            dfs_main((element.data as AdjList), list)
        }
        element = element.next
    }

    return list
}
