package com.example.homework_1.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentProfileBinding
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.log_in_page.LogInFragment
import com.example.homework_1.ui.notes_list.NotesListFragment
import com.example.homework_1.util.replaceFragment
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels()

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefreshLayout.setOnRefreshListener {
            SharedPreferenceRepository.getUserEmail()?.let {
                lifecycleScope.launch {
                    binding.profileName.text = viewModel.getUserNameByEmail(it)
                    binding.numberOfNotes.text = viewModel.getUserNotesNumber(it)
                }
            }
            binding.swipeRefreshLayout.isRefreshing = false
        }


        SharedPreferenceRepository.getUserEmail()?.let {
            lifecycleScope.launch {
                binding.profileName.text = viewModel.getUserNameByEmail(it)
                binding.numberOfNotes.text = viewModel.getUserNotesNumber(it)
            }
        }

        binding.deleteNotes.setOnClickListener {
            SharedPreferenceRepository.getUserEmail()?.let { it1 -> viewModel.deleteAllNotes(it1) }
            Toast.makeText(requireContext(), "All notes deleted!", Toast.LENGTH_SHORT).show()
        }

        binding.logOut.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), false)
            SharedPreferenceRepository.clearUserPreferences()
        }

        binding.deleteProfileButton.setOnClickListener {
            SharedPreferenceRepository.getUserEmail()?.let { it1 ->
                viewModel.deleteAllNotes(it1)
                viewModel.deleteUser(it1)
            }
            parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), false)
            SharedPreferenceRepository.clearUserPreferences()
        }

    }
}