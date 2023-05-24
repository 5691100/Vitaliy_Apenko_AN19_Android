package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInActivation.setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
        }

        binding.signUpActivation.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.discoverButton.setOnClickListener {
            startActivity(Intent(this, OnboardingFirstActivity::class.java))
        }





    }
}