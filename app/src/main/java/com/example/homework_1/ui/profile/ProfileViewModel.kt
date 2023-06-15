package com.example.homework_1.ui.profile

import androidx.lifecycle.MutableLiveData
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

    val user = MutableLiveData<String>()
    val numberOfNotes = MutableLiveData<Int>()

    fun getUserNameByEmail(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            user.postValue("${userRepository.getUser(email)?.firstName} ${userRepository.getUser(email)?.secondName}")
        }
    }

    fun getUserNotesNumber(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            numberOfNotes.postValue(noteRepository.getUserNotesByEmail(email).size)
        }
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
            if (user != null) {
                userRepository.removeUser(user)
            }
        }
    }
}


