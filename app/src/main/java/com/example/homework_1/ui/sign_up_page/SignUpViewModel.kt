package com.example.homework_1.ui.sign_up_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.User
import com.example.homework_1.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var userSaved: (() -> Unit)? = null

    fun addNewUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
            val isUserSaved = userRepository.addUser(user)
            if (isUserSaved) {
                userSaved?.invoke()
            }
        }
    }
}