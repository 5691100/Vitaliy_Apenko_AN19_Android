package com.example.homework_1.ui.search.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homework_1.databinding.ItemNoteBinding
import com.example.homework_1.model.Note
import java.util.*

class SearchViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.run {
            title.text = note.title
            message.text = note.message
            date.text = Date().toString()
        }
    }
}