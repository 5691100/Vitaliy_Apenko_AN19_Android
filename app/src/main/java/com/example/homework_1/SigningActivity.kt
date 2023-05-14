package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_1.databinding.ActivitySigningBinding

class SigningActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySigningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, LoggingActivity::class.java))
            Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show()
        }
    }
}