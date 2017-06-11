package com.yourtion.stack

/**
 * Events
 * Created by Yourtion on 09/06/2017.
 */

data class Event<E> constructor(val type: E, val data: Any? = null)

class Events<E> : Queue<Event<E>>() {

    fun receive_event(type: E, data: Any? = null) {
        enqueue(Event(type, data))
    }

    fun process_event(dispatch: (Event<E>) -> Unit) {
        if (size == 0) return
        dispatch(dequeue()!!)
    }

}
