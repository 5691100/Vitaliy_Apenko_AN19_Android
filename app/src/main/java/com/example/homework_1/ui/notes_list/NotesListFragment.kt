package com.example.homework_1.ui.notes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentNotesListBinding
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.add_note.AddNoteFragment
import com.example.homework_1.ui.notes_list.adapter.NoteAdapter
import com.example.homework_1.ui.profile.ProfileFragment
import com.example.homework_1.ui.search.SearchFragment
import com.example.homework_1.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesListFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

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
            sharedPreferenceRepository.getUserEmail()?.let {
                getUserNotes(it)
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
