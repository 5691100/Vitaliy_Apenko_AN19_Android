package com.example.homework_1.ui.notes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.NoteRepository

class NotesListViewModel: ViewModel() {

    val notesList = MutableLiveData<ArrayList<Note>?>()

    private val notesRepository = NoteRepository()

    fun getNotes() {
        notesList.value = notesRepository.getNotes()
    }

    fun getUserNotes(email:String) {
        val userNotes = ArrayList<Note>()
        notesRepository.getNotes()
        val allNotes = notesRepository.getNotes()
        for (note in allNotes) {
            if (note.userEmail == email) {
                userNotes.add(note)
            }
        }
        notesList.value = userNotes
    }
}