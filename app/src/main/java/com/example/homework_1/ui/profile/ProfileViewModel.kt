package com.example.homework_1.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.repositories.NoteRepository
import com.example.homework_1.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    suspend fun getUserNameByEmail(email: String): String {
        val isUserExist = userRepository.getUser(email)
        return "${isUserExist.firstName} ${isUserExist.secondName}"
    }

    suspend fun getUserNotesNumber(email: String): String {
        val userNotes = noteRepository.getUserNotesByEmail(email)
        return "${userNotes.size} notes"
    }

    fun deleteAllNotes(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val userNotes = noteRepository.getUserNotesByEmail(email)

            for (note in userNotes) {
                noteRepository.removeNote(note)
            }
        }
    }

    fun deleteUser(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(email)
            userRepository.removeUser(user)
        }
    }
}


