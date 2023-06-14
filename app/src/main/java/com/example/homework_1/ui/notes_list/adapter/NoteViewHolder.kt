package com.example.homework_1.ui.notes_list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homework_1.databinding.ItemNoteBinding
import com.example.homework_1.model.Note
import com.example.homework_1.util.addLines
import java.util.*

class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.run {
            title.text = note.title
            message.text = note.message
            date.text = Date().toString()
            message.setOnClickListener {
                message.addLines()
            }
        }

    }
}