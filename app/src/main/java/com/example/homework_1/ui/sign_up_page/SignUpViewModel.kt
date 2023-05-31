package com.example.homework_1.ui.sign_up_page

import androidx.lifecycle.ViewModel
import com.example.homework_1.model.User
import com.example.homework_1.repositories.UserRepository

class SignUpViewModel(): ViewModel() {

    var userSaved: (()->Unit) ?= null

    private val userRepository = UserRepository()

    fun addNewUser(user: User) {
        userRepository.addUser(user)
        val isUserSaved = userRepository.addUser(user)
        if (isUserSaved) {
            userSaved?.invoke()
        }
    }
}