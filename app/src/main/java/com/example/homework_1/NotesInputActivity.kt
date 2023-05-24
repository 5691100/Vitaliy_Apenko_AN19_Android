package com.example.homework_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_1.databinding.ActivityNotesInputBinding
import com.example.homework_1.db.NotesDataBase
import com.example.homework_1.util.getText
import java.util.*

class NotesInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addNoteButton.setOnClickListener {
        val title = binding.titleAddInputLayout.getText()
        val message = binding.messageAddInputLayout.getText()

            val note = Notes(title, message, Date())
            NotesDataBase.addNotes(note)
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.backToNotes.setOnClickListener {
            finish()
        }
    }
}