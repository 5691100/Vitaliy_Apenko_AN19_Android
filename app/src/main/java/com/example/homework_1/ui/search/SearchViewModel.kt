package com.example.homework_1.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {

    val notesList = MutableLiveData<ArrayList<Note>?>()

    private val notesRepository = NoteRepository()

    fun getUserSearchedNotes(email: String, input: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val userNotesList = notesRepository.getUserNotesByEmail(email)
            val userSearchList = ArrayList<Note>()
            for (note in userNotesList) {
                if (note.title.contains(input) || note.message.contains(input)) {
                    userSearchList.add(note)
                }
            }
            notesList.postValue(userSearchList)
        }
    }
}
