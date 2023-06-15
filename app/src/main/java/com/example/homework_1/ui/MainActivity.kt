package com.example.homework_1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_1.R
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.sign_up_page.SignUpFragment
import com.example.homework_1.ui.start_page.StartFragment
import com.example.homework_1.util.replaceFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (SharedPreferenceRepository.isFirstOpen()) {
            SharedPreferenceRepository.setIsFirstOpen(false)
            supportFragmentManager.replaceFragment(R.id.container, StartFragment())
        } else {
            supportFragmentManager.replaceFragment(R.id.container, SignUpFragment())
        }
    }
}