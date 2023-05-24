package com.example.homework_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_1.Notes
import com.example.homework_1.databinding.ItemNotesBinding

class NotesAdapter : RecyclerView.Adapter<NotesViewHolder>() {

    private var notesList = arrayListOf<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNotesBinding.inflate(inflater, parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notesList[position]
        holder.bind(note)
    }

    override fun getItemCount() = notesList.size

    fun setList (list: ArrayList<Notes>) {
        this.notesList = list
        notifyDataSetChanged()
    }
}

