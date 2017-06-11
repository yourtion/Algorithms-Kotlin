package com.yourtion.set

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * SetCoveringTest
 * Created by Yourtion on 09/06/2017.
 */
class SetCoveringTest {

    fun create_skills(skills:String, split:String = ""): Set<String> {
        val skill_arr = skills.split(split)
        val skill_set = Set<String>()
        skill_arr
                .filter { it !="" }
                .forEach { skill_set.insert(it) }
        return skill_set
    }

    fun create_player(key:Int, skills:String, split:String = ""): KSet<Int, String> {
        val skill_arr = skills.split(split)
        val skill_set = Set<String>()
        skill_arr
                .filter { it != "" }
                .forEach { skill_set.insert(it) }
        return KSet(key, skill_set)
    }

    fun verify(res: Set<KSet<Int, String>>, result: Array<KSet<Int, String>>) {
        for((index, player) in res.withIndex()) {
            assertEquals(player.key, result[index].key)
        }
    }

    @Test
    fun cover() {
        println("Creating the set of skills")
        val skills = create_skills("abcdefghijkl")
        assertEquals(skills.size, 12)

        println("Creating the player subsets")
        val plays = Set<KSet<Int, String>>()

        val p1 = create_player(1, "abcd")
        assertEquals(p1.set.size, 4)
        plays.insert(p1)
        val p2 = create_player(2, "efghi")
        plays.insert(p2)
        val p3 = create_player(3, "jkl")
        plays.insert(p3)
        val p4 = create_player(4, "ae")
        plays.insert(p4)
        val p5 = create_player(5, "bfg")
        plays.insert(p5)
        val p6 = create_player(6, "cdghkl")
        plays.insert(p6)
        val p7 = create_player(7, "l")
        plays.insert(p7)

        assertEquals(plays.size, 7)

        println("Generating the cover")
        val res = plays.cover(skills)
        assertEquals(skills.size, 0)
        assertEquals(plays.size, 7)
        verify(res!!, arrayOf(p6, p2, p1, p3))
    }

}