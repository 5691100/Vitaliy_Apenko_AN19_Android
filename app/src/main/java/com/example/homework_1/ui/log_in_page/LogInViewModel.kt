package com.example.homework_1.ui.log_in_page

import androidx.lifecycle.ViewModel
import com.example.homework_1.model.User
import com.example.homework_1.repositories.UserRepository

class LogInViewModel : ViewModel() {

    private val userRepository = UserRepository()

    fun findUserByEmail(email: String): User? {
        val userList = userRepository.getUsers()
        var isUserExist: User ?= null
        for (user in userList) {
            if (user.userEmail == email) {
                isUserExist = user
            }
        }
        return isUserExist
    }
}