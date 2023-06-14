package com.example.homework_1.ui.notes_list.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.homework_1.databinding.FragmentEditMessageBinding
import com.example.homework_1.model.Note
import com.example.homework_1.ui.notes_list.NotesListViewModel
import com.example.homework_1.util.getString
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditMessageFragment : BottomSheetDialogFragment() {

    private val viewModel: EditMessageViewModel by viewModels()

//    private val viewModel: NotesListViewModel by viewModels()

    private lateinit var binding: FragmentEditMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("Id") { key, bundle ->
            val id = bundle.getLong("bundleKey")
            viewModel.findNoteById(id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            note.observe(viewLifecycleOwner) {
                binding.inputEditText.setText(it.message)
            }
        }
        binding.editButton.setOnClickListener {
            viewModel.run {
                note.observe(viewLifecycleOwner) {
                    replaceNote(
                        Note(
                            it.id,
                            it.userEmail,
                            it.title,
                            binding.inputEditText.getString(),
                            it.date
                        ))
                    val id = it.id
                    setFragmentResult("NewId", bundleOf("bundleKey" to id))
                    Toast.makeText(requireContext(), "Note edited!", Toast.LENGTH_LONG).show()
                    dismiss()
                }
            }
        }
    }
}

