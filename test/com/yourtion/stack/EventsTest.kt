package com.yourtion.stack

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Yourtion on 09/06/2017.
 */
class EventsTest {
    @Test
    fun receive_event() {
        val events = Events<Int>()
        events.receive_event(1)
        events.receive_event(2, 3)
        events.receive_event(3, "A")
        assertEquals(events.size, 3)
    }

    val dispatch = { e: Event<Int> -> println(e) }

    @Test
    fun process_event() {
        val events = Events<Int>()
        events.receive_event(1)
        events.receive_event(2, 3)
        events.receive_event(3, "A")
        assertEquals(events.size, 3)
        events.process_event(dispatch)
        assertEquals(events.size, 2)
        events.process_event(dispatch)
        assertEquals(events.size, 1)
        events.process_event(dispatch)
        assertEquals(events.size, 0)
        events.process_event(dispatch)
        assertEquals(events.size, 0)
    }

}
