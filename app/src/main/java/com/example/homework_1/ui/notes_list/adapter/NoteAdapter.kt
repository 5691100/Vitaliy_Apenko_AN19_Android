package com.example.homework_1.ui.notes_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.homework_1.databinding.ItemNoteBinding
import com.example.homework_1.model.Note

class NoteAdapter (
    private val onLongClick: (note:Note, itemView: View) -> Unit
        ) : ListAdapter<Note, NoteViewHolder>(
    object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnLongClickListener(View.OnLongClickListener {
            onLongClick(getItem(position), it)
            return@OnLongClickListener true
        })
    }
}