package com.example.homework_1.ui.add_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentAddNoteBinding
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.notes_list.NotesListFragment
import com.example.homework_1.util.getString
import com.example.homework_1.util.replaceFragment
import com.example.homework_1.validate.ValidationResult
import com.example.homework_1.validate.titleValidation
import java.util.*

class AddNoteFragment : Fragment() {

    private val viewModel: AddNoteViewModel by viewModels()

    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            noteSaved = {
                binding.root.post {
                    Toast.makeText(requireContext(), "NoteSaved", Toast.LENGTH_LONG).show()
                    parentFragmentManager.replaceFragment(
                        R.id.container2,
                        NotesListFragment(),
                        true
                    )
                }
            }
        }

        binding.titleAddEditText.doAfterTextChanged {
            isValidTitle()
        }
        binding.addNoteButton.setOnClickListener {
            addNote()
        }
    }

    private fun isValidTitle(): Boolean {
        val titleValidationResult = titleValidation(binding.titleAddEditText.getString())
        when (titleValidationResult) {
            is ValidationResult.Invalid -> binding.titleAddInputLayout.error =
                requireContext().getString(titleValidationResult.errorId)
            else -> binding.titleAddInputLayout.error = null
        }
        val isValidTitle = titleValidationResult == ValidationResult.Valid
        binding.addNoteButton.isEnabled = isValidTitle
        return isValidTitle
    }

    private fun addNote() {
        val email = SharedPreferenceRepository.getUserEmail()
        if (email != null) {
            viewModel.addNewNote(
                Note(
                    email,
                    binding.titleAddEditText.getString(),
                    binding.messageAddEditText.getString(),
                    Date().time
                )
            )
        }
    }
}