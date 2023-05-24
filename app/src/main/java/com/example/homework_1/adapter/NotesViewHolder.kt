package com.example.homework_1.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.homework_1.Notes
import com.example.homework_1.databinding.ItemNotesBinding

class NotesViewHolder(private val binding: ItemNotesBinding): ViewHolder(binding.root) {

    fun bind (note: Notes) {
        binding.title.text = note.title
        binding.message.text = note.message
        binding.date.text = note.date.toString()
    }
}