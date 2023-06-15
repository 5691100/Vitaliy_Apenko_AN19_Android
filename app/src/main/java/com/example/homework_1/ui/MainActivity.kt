package com.example.homework_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_1.R
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.log_in_page.LogInFragment
import com.example.homework_1.ui.notes_list.NavigationFragment
import com.example.homework_1.ui.start_page.StartFragment
import com.example.homework_1.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (sharedPreferenceRepository.isFirstOpen()) {
            sharedPreferenceRepository.setIsFirstOpen(false)
            supportFragmentManager.replaceFragment(R.id.container, StartFragment())
        } else if (sharedPreferenceRepository.getUserEmail() == null) {
            supportFragmentManager.replaceFragment(R.id.container, LogInFragment())
        } else {
            supportFragmentManager.replaceFragment(R.id.container, NavigationFragment())
        }
    }
}