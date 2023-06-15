package com.example.homework_1.ui.notes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository
import com.example.homework_1.repositories.SharedPreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesListViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val sharedPreferenceRepository: SharedPreferenceRepository
) : ViewModel() {

    val notesList = MutableLiveData<ArrayList<Note>?>()

    fun getUserNotes(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            notesList.postValue(noteRepository.getUserNotesByEmail(email))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.removeNote(note)
            sharedPreferenceRepository.getUserEmail()?.let { getUserNotes(it) }
        }
    }

//    val note = MutableLiveData<Note>()
//
//    fun findNoteById(id: Long) {
//        viewModelScope.launch {
//            note.postValue(noteRepository.getNotesWithId(id))
//        }
//    }
//
//    var isNoteReplaced: (()->Unit)? = null
//
//    fun replaceNote(note: Note) {
//        viewModelScope.launch(Dispatchers.IO) {
//            noteRepository.replaceNote(note)
//            isNoteReplaced?.invoke()
//
//        }
//    }

}