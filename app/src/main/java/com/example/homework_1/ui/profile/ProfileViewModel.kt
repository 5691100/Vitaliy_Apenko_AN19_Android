package com.example.homework_1.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.Note
import com.example.homework_1.model.User
import com.example.homework_1.repositories.NoteRepository
import com.example.homework_1.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val notesRepository = NoteRepository()
    val userRepository = UserRepository()

    suspend fun getUserNameByEmail(email: String): String {
        val isUserExist = userRepository.getUser(email)
        return if (isUserExist != null) {
            "${isUserExist.firstName} ${isUserExist.secondName}"
        } else {
            ""
        }
    }

    suspend fun getUserNotesNumber(email: String): String {
        val userNotes = notesRepository.getUserNotesByEmail(email)
        return "${userNotes.size} notes"
    }

    fun deleteAllNotes(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val userNotes = notesRepository.getUserNotesByEmail(email)

            for (note in userNotes) {
                notesRepository.removeNote(note)
            }
        }
    }

    fun deleteUser(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(email)
            if (user != null) {
                userRepository.removeUser(user)
            }
        }
    }
}


