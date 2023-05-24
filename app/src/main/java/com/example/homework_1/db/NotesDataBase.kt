package com.example.homework_1.db

import com.example.homework_1.Notes
import com.example.homework_1.Subscriber

object NotesDataBase {

    private val listSubscribers = arrayListOf<Subscriber>()

    fun subscribe(s: Subscriber) {
        listSubscribers.add(s)
    }

    fun unsubscribe(s: Subscriber) {
        listSubscribers.remove(s)
    }

    private fun notifySubscribers() {
        listSubscribers.forEach{
            it.update()
        }
    }
    private val notesList = ArrayList<Notes>()

    fun addNotes(note: Notes) {
        notesList.add(note)
        notifySubscribers()
    }

    fun getListNotes() = notesList
}