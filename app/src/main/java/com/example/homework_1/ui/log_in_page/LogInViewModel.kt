package com.example.homework_1.ui.log_in_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1.model.User
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val sharedPreferenceRepository: SharedPreferenceRepository
    ) : ViewModel() {

    var isPasswordCorrect: (() -> Unit)? = null
    var isPasswordIncorrect: (() -> Unit)? = null
    var isUserNotExist: (() -> Unit)? = null

    fun checkLogin(email: String, password: String) {

        viewModelScope.launch(Dispatchers.IO) {
            val user = userRepository.getUser(email)
            if (user.userEmailPassword == password) {
                sharedPreferenceRepository.saveUserEmail(email)
                isPasswordCorrect?.invoke()
            } else {
                isPasswordIncorrect?.invoke()
            }
        }
    }
}
