package com.example.homework_1.repositories

import com.example.homework_1.db.DataBase
import com.example.homework_1.model.Note
import com.example.homework_1.model.entity.NoteEntity

class NoteRepository {

    fun getNotes(): ArrayList<Note> {
        return (DataBase.noteDao?.getAllNotes()?.map {
            Note(
                it.userEmail,
                it.title,
                it.message,
                it.date
            )
        } as? ArrayList<Note>) ?: arrayListOf()
    }

    fun addNotes(note: Note): Boolean {
        DataBase.noteDao?.insertNote(
            NoteEntity(
                0,
            note.userEmail,
            note.title,
            note.message,
            note.date
        )
        )
        return true
    }

    fun removeNote(note: Note) {
        DataBase.listOfNotes.remove(note)
    }


}