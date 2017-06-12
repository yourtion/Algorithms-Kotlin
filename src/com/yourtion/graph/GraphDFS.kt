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

    var clr_adjlist: AdjList<DFSVertex<E>>?
    for (element in adjlist.adjacent) {
        clr_adjlist = get_adjlist(element)

        if (clr_adjlist != null && clr_adjlist.vertex.color == VertexColor.White) {
            dfs_main(clr_adjlist, ordered)
        }
    }

    adjlist.vertex.color = VertexColor.Black

    ordered.insert_next(adjlist.vertex)
}

/**
 * 广度搜索
 */
fun <E> Graph<DFSVertex<E>>.dfs(): List<DFSVertex<E>> {
    for ((vertex) in adjlists) {
        vertex.color = VertexColor.White
    }

    val list = List<DFSVertex<E>>()
    adjlists
            .asSequence()
            .filter { it.vertex.color == VertexColor.White }
            .forEach { dfs_main(it, list) }

    return list
}
