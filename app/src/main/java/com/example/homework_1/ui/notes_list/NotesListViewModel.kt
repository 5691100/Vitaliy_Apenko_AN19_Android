package com.example.homework_1.ui.notes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    val notesList = MutableLiveData<ArrayList<Note>?>()


    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(noteRepository.getNotes())
        }
    }

    fun getUserNotes(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(noteRepository.getUserNotesByEmail(email))
        }
    }
}