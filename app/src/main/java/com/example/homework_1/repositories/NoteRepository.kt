package com.example.homework_1.repositories

import com.example.homework_1.db.DataBaseModule
import com.example.homework_1.db.NoteDao
import com.example.homework_1.model.Note
import com.example.homework_1.model.entity.NoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    suspend fun getNotes(): ArrayList<Note> {
        return (noteDao.getAllNotes()?.map {
            Note(
                it.id,
                it.userEmail,
                it.title,
                it.message,
                it.date
            )
        } as? ArrayList<Note>) ?: arrayListOf()
    }

    suspend fun getUserNotesByEmail(email: String): ArrayList<Note> {
        return (noteDao.getNotesByEmail(email)?.map {
            Note(
                it.id,
                it.userEmail,
                it.title,
                it.message,
                it.date
            )
        } as? ArrayList<Note>) ?: arrayListOf()
    }

    suspend fun addNotes(note: Note): Boolean {
        noteDao.insertNote(
            NoteEntity(
                note.id,
                note.userEmail,
                note.title,
                note.message,
                note.date
            )
        )
        return true
    }

    suspend fun removeNote(note: Note) {
        noteDao.deleteNote(
            NoteEntity(
                note.id,
                note.userEmail,
                note.title,
                note.message,
                note.date
            )
        )
    }
}