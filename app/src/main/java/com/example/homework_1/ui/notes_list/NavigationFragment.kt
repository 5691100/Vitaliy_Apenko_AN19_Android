package com.example.homework_1.ui.notes_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentNavigationBinding
import com.example.homework_1.ui.add_note.AddNoteFragment
import com.example.homework_1.ui.profile.ProfileFragment
import com.example.homework_1.ui.search.SearchFragment
import com.example.homework_1.util.replaceFragment

class NavigationFragment : Fragment() {

    private lateinit var binding: FragmentNavigationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.replaceFragment(R.id.container2, NotesListFragment(), true)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.notes_list -> {
                    parentFragmentManager.replaceFragment(
                        R.id.container2,
                        NotesListFragment(),
                        true
                    )
                    return@setOnItemSelectedListener true
                }
                R.id.search -> {
                    parentFragmentManager.replaceFragment(R.id.container2, SearchFragment(), true)
                    return@setOnItemSelectedListener true
                }
                R.id.add_note -> {
                    parentFragmentManager.replaceFragment(R.id.container2, AddNoteFragment(), true)
                    return@setOnItemSelectedListener true
                }
                R.id.profile -> {
                    parentFragmentManager.replaceFragment(R.id.container2, ProfileFragment(), true)
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener true
            }
        }
    }
}