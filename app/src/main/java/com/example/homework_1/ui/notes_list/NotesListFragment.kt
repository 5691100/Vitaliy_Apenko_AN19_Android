package com.example.homework_1.ui.notes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentNotesListBinding
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.add_note.AddNoteFragment
import com.example.homework_1.ui.notes_list.adapter.NoteAdapter
import com.example.homework_1.ui.profile.ProfileFragment
import com.example.homework_1.ui.search.SearchFragment
import com.example.homework_1.util.replaceFragment

class NotesListFragment : Fragment() {

    private val viewModel: NotesListViewModel by viewModels()

    private lateinit var binding: FragmentNotesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            notesList.observe(viewLifecycleOwner) {
                if (it != null) {
                    setList(it)
                }
            }
            SharedPreferenceRepository.getUserEmail()?.let { getUserNotes(it) }
        }

        binding.addNewNote.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, AddNoteFragment(), true)
        }
        binding.logOut.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.notes_list -> {
                    parentFragmentManager.replaceFragment(R.id.container, NotesListFragment(), true)
                    return@setOnItemSelectedListener true
                }
                R.id.search -> {
                    parentFragmentManager.replaceFragment(R.id.container, SearchFragment(), true)
                    return@setOnItemSelectedListener true
                }
                R.id.add_note -> {
                    parentFragmentManager.replaceFragment(R.id.container, AddNoteFragment(), true)
                    return@setOnItemSelectedListener true
                }
                R.id.profile -> {
                    parentFragmentManager.replaceFragment(R.id.container, ProfileFragment(), true)
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener true
            }
        }
    }

    private fun setList(list: ArrayList<Note>) {
        binding.notesRecyclerView.run {
            if (adapter == null) {
                adapter = NoteAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? NoteAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }
}
