package com.example.homework_1.ui.notes_list

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentNotesListBinding
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.add_note.AddNoteFragment
import com.example.homework_1.ui.notes_list.adapter.NoteAdapter
import com.example.homework_1.ui.notes_list.dialog.EditMessageFragment
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
    ): View {
        binding = FragmentNotesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("NewId") { key, bundle ->
            val id = bundle.getLong("bundleKey")
            sharedPreferenceRepository.getUserEmail()?.let {
                viewModel.getUserNotes(it)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            sharedPreferenceRepository.getUserEmail()?.let {
                getUserNotes(it)
            }
            notesList.observe(viewLifecycleOwner) {
                if (it != null) {
                    setList(it)
                }
            }
        }
    }

    private fun setList(list: ArrayList<Note>) {
        binding.notesRecyclerView.run {
            if (adapter == null) {
                adapter = NoteAdapter { note, view ->
                    showPopup(note, view)
                }
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? NoteAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }

    private fun showPopup(note: Note, v: View) {
        val popup = PopupMenu(requireContext(), v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.menu_note, popup.menu)
        popup.setOnMenuItemClickListener { it ->
            when (it.itemId) {
                R.id.delete -> {
                    showDeleteDialog(note)
                }
                R.id.edit_message -> {
                    showEditDialog(note)
                }
            }
            return@setOnMenuItemClickListener true
        }
        popup.show()
    }

    private fun showDeleteDialog(note: Note) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete note?")
            .setPositiveButton("Yes") { _, _ ->
                viewModel.deleteNote(note)
            }
            .setNegativeButton("No") { _, _ ->

            }
            .show()
    }

    private fun showEditDialog(note: Note) {
        val id = note.id
        setFragmentResult("Id", bundleOf("bundleKey" to id))
        EditMessageFragment().show(parentFragmentManager, "Edit message")
    }
}
