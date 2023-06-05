package com.example.homework_1.ui.log_in_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.User
import com.example.homework_1.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LogInViewModel : ViewModel() {

    private val userRepository = UserRepository()

    var isPasswordCorrect: (() -> Unit)? = null
    var isPasswordIncorrect: (() -> Unit)? = null
    var isUserNotExist: (() -> Unit)? = null

    fun checkLogin(email: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(email)
            if (user != null) {
                if (user.userEmailPassword == password) {
                    isPasswordCorrect?.invoke()
                } else {
                    isPasswordIncorrect?.invoke()
                }
            } else {
                isUserNotExist?.invoke()
            }
        }
    }
}
