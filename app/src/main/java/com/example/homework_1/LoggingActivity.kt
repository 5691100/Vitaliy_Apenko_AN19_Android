package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_1.databinding.ActivityLoggingBinding

class LoggingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoggingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnToSigning.setOnClickListener {
            startActivity(Intent(this, SigningActivity::class.java))
        }
    }
}