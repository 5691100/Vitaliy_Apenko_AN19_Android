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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

    private val viewModel: ProfileViewModel by viewModels()

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeRefreshLayout.setOnRefreshListener {
            sharedPreferenceRepository.getUserEmail()?.let {
                viewModel.getUserNameByEmail(it)
                viewModel.getUserNotesNumber(it)
            }
            viewModel.run {
                user.observe(viewLifecycleOwner) {
                    binding.profileName.text = it
                }
                numberOfNotes.observe(viewLifecycleOwner) {
                    binding.numberOfNotes.text = it.toString()
                }
            }
            binding.swipeRefreshLayout.isRefreshing = false
        }

        sharedPreferenceRepository.getUserEmail()?.let {
            viewModel.getUserNameByEmail(it)
            viewModel.getUserNotesNumber(it)
        }
        viewModel.run {
            user.observe(viewLifecycleOwner) {
                binding.profileName.text = it
            }
            numberOfNotes.observe(viewLifecycleOwner) {
                binding.numberOfNotes.text = it.toString()
            }
        }

        binding.deleteNotes.setOnClickListener {
            sharedPreferenceRepository.getUserEmail()
                ?.let { email -> viewModel.deleteAllNotes(email) }
            Toast.makeText(requireContext(), "All notes deleted!", Toast.LENGTH_SHORT).show()
        }

        binding.logOut.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), false)
            sharedPreferenceRepository.clearUserPreferences()
        }

        binding.deleteProfileButton.setOnClickListener {
            sharedPreferenceRepository.getUserEmail()?.let { email ->
                viewModel.deleteAllNotes(email)
                viewModel.deleteUser(email)
            }
            parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), false)
            sharedPreferenceRepository.clearUserPreferences()
        }
    }
}