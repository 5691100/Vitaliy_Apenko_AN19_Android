package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework_1.databinding.ActivityLoginBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInButton.setOnClickListener {
            startActivity(Intent(this, NotesCollectionActivity::class.java))
            Toast.makeText(this, "Log-in successful!", Toast.LENGTH_SHORT).show()
        }

        binding.returnToSigning.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}