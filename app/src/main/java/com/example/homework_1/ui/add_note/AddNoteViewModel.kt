package com.example.homework_1.ui.add_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    var noteSaved: (() -> Unit)? = null

    private val noteRepository = NoteRepository()

    fun addNewNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            val isNoteSaved = noteRepository.addNotes(note)
            if (isNoteSaved) {
                noteSaved?.invoke()
            }
        }
    }
}