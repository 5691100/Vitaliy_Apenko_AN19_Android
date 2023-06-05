package com.example.homework_1.ui.sign_up_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.User
import com.example.homework_1.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel() : ViewModel() {

    var userSaved: (() -> Unit)? = null

    private val userRepository = UserRepository()

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