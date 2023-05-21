package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_1.adapter.ListNotesAdapter
import com.example.homework_1.adapter.NotesAdapter
import com.example.homework_1.databinding.ActivityMainBinding
import com.example.homework_1.databinding.ActivityNotesCollectionBinding
import com.example.homework_1.db.NotesDataBase
import java.util.*

class NotesCollectionActivity : AppCompatActivity(), Subscriber {
    private lateinit var binding: ActivityNotesCollectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NotesDataBase.subscribe(this)

        binding.notesRecyclerView.run {
            layoutManager = LinearLayoutManager(this@NotesCollectionActivity)
            adapter = ListNotesAdapter()
            (adapter as ListNotesAdapter)?.submitList(NotesDataBase.getListNotes())
//                arrayListOf(
//                    Notes("Title 1", "Message 1", Date()),
//                    Notes("Title 2", "Message 2", Date()),
//                    Notes("Title 3", "Message 3", Date()),
//                    Notes("Title 4", "Message 4", Date()),
//                    Notes("Title 5", "Message 5", Date()),
//                    Notes("Title 6", "Message 6", Date()),
//                    Notes("Title 7", "Message 7", Date()),
//                    Notes("Title 8", "Message 8", Date()),
//                    Notes("Title 9", "Message 9", Date()),
//                    Notes("Title 10", "Message 10", Date()),
//                    Notes("Title 11", "Message 11", Date()),
//                    Notes("Title 12", "Message 12", Date()),
//                    Notes("Title 13", "Message 13", Date()),
//                    Notes("Title 14", "Message 14", Date()),
//                    Notes("Title 15", "Message 15", Date()),
//                    Notes("Title 16", "Message 16", Date()),
//                    Notes("Title 17", "Message 17", Date()),
//                    Notes("Title 18", "Message 18", Date()),
//                    Notes("Title 19", "Message 19", Date())
//                ))
        }

        binding.logOut.setOnClickListener {
            finish()
        }

        binding.addNewNote.setOnClickListener {
            startActivity(Intent(this, NotesInputActivity::class.java))
        }
    }

    override fun update() {
        binding.notesRecyclerView.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(this@NotesCollectionActivity)
                adapter = ListNotesAdapter()
            }
            (adapter as ListNotesAdapter)?.submitList(NotesDataBase.getListNotes())
            adapter?.notifyDataSetChanged()
        }
    }
}