package com.example.homework_1.ui.add_note

import androidx.lifecycle.ViewModel
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository

class AddNoteViewModel : ViewModel() {

    var noteSaved: (() -> Unit)? = null

    private val noteRepository = NoteRepository()

    fun addNewNote(note: Note) {
        val isNoteSaved = noteRepository.addNotes(note)
        if (isNoteSaved) {
            noteSaved?.invoke()
        }
    }
}