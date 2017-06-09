package com.yourtion.hash

/**
 * Created by Yourtion on 05/06/2017.
 */
class OpenAddressedHashTables constructor(positions: Int, h1: (Any) -> Int, h2: (Any) -> Int) {

    internal class OAHTDelete {}

    val positions = positions
    val h1 = h1
    val h2 = h2
    var size = 0
        private set
    internal val table = Array<Any?>(positions, { _ -> null })
    internal val vacated = OAHTDelete()

    fun insert(data: Any): Boolean {
        if (size == positions) return false
        if (lookup(data)) return false
        for (i in IntRange(0, positions - 1)) {
            val pos = (h1(data) + i * h2(data)) % positions

            if (table[pos] == null || table[pos] == vacated) {
                table[pos] = data
                size++
                return true
            }
        }
        return false
    }

    fun remove(data: Any): Boolean {
        for (i in IntRange(0, positions - 1)) {
            val pos = (h1(data) + i * h2(data)) % positions
            if (table[pos] == null) return false
            if (table[pos] == data) {
                table[pos] = vacated
                size--
                return true
            }
        }
        return false
    }

    fun lookup(data: Any): Boolean {
        for (i in IntRange(0, positions - 1)) {
            val pos = (h1(data) + i * h2(data)) % positions
            if (table[pos] == null) return false
            if (table[pos] == data) return true
        }
        return false
    }

}
