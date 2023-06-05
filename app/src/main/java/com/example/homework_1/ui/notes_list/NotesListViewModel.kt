package com.example.homework_1.ui.notes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesListViewModel : ViewModel() {

    val notesList = MutableLiveData<ArrayList<Note>?>()

    private val notesRepository = NoteRepository()

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(notesRepository.getNotes())
        }
    }

    fun getUserNotes(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(notesRepository.getUserNotesByEmail(email))
        }
    }
}