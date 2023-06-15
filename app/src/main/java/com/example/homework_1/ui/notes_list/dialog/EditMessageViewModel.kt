package com.example.homework_1.ui.notes_list.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditMessageViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val note = MutableLiveData<Note>()

    fun findNoteById(id: Long) {
        viewModelScope.launch {
            note.postValue(noteRepository.getNotesWithId(id))
        }
    }

    fun replaceNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.replaceNote(note)
        }
    }
}