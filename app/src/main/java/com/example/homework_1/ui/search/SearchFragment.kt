package com.example.homework_1.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_1.databinding.FragmentSearchBinding
import com.example.homework_1.model.Note
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.search.adapter.SearchAdapter
import com.example.homework_1.util.getString
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    @Inject
    lateinit var sharedPreferenceRepository: SharedPreferenceRepository

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchEditText.doAfterTextChanged {

            val input = binding.searchEditText.getString()
            sharedPreferenceRepository.getUserEmail()?.let {
                viewModel.run {
                    getUserSearchedNotes(it, input)
                    notesList.observe(/* owner = */ viewLifecycleOwner) {
                        if (it != null) {
                            setList(it)
                        }
                    }
                }
            }
        }
    }

    private fun setList(list: ArrayList<Note>) {
        binding.searchRecyclerView.run {
            if (adapter == null) {
                adapter = SearchAdapter()
                layoutManager = LinearLayoutManager(requireContext())
            }
            (adapter as? SearchAdapter)?.submitList(list)
            adapter?.notifyDataSetChanged()
        }
    }
}
