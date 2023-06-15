package com.example.homework_1.repositories

import com.example.homework_1.db.NoteDao
import com.example.homework_1.model.Note
import com.example.homework_1.util.toListNote
import com.example.homework_1.util.toNote
import com.example.homework_1.util.toNoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) {

    suspend fun getNotesWithId(id: Long): Note {
        return noteDao.getNoteWithId(id).toNote()
    }

    suspend fun getUserNotesByEmail(email: String): ArrayList<Note> {
        return (noteDao.getNotesByEmail(email).map {
            it.toNote()
        } as? ArrayList<Note>) ?: arrayListOf()
    }

    suspend fun getSearchedNotesByEmail(email: String, search: String): ArrayList<Note> {
        return (noteDao.getSearchByEmail(email, search).toListNote())
    }

    suspend fun addNotes(note: Note): Boolean {
        noteDao.insertNote(note.toNoteEntity())
        return true
    }

    suspend fun removeNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    suspend fun replaceNote(note: Note): Boolean {
        noteDao.insertNote(note.toNoteEntity())
        return true
    }
}