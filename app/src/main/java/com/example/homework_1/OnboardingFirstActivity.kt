package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_1.databinding.ActivitySecondBinding

class OnboardingFirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.skipButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}