package com.example.homework_1.ui.add_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
) : ViewModel() {



    var noteSaved: (() -> Unit)? = null

    fun addNewNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            val isNoteSaved = noteRepository.addNotes(note)
            if (isNoteSaved) {
                noteSaved?.invoke()
            }
        }
    }
}