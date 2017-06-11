package com.yourtion.set

/**
 * Set Covering
 * Created by Yourtion on 09/06/2017.
 */

data class KSet<E, T> constructor(val key: E, val set: Set<T>)

private fun <E, T> Set<KSet<E, T>>.copy(): Set<KSet<E, T>> {
    val copy_set = Set<KSet<E, T>>()
    this.forEach { e ->
        copy_set.insert(e.copy())
    }
    return copy_set
}

fun <E, T> Set<KSet<E, T>>.cover(members: Set<T>): Set<KSet<E, T>>? {
    val covering = Set<KSet<E, T>>()
    var intersection: Set<T>
    var max_member: KSet<E, T>? = null
    var max_size: Int
    val copy_set = this.copy()

    while (copy_set.size > 0 && members.size > 0) {
        max_size = 0
        for (subset in copy_set) {
            intersection = subset.set.intersection(members)
            if (intersection.size > max_size) {
                max_member = subset
                max_size = intersection.size
            }
        }

        if (max_size == 0) return null

        covering.insert(max_member!!)

        max_member.set.forEach { member -> members.remove(data = member) }

        copy_set.remove(max_member)
    }

    if (members.size > 0) return null

    return covering
}


