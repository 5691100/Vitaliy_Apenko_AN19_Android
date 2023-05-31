package com.example.homework_1.ui.onboarding_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_1.databinding.FragmentOnboardFirstBinding

class OnboardFirstFragment : Fragment() {

    class OnboardFirstFragment : Fragment() {
        private lateinit var binding: FragmentOnboardFirstBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentOnboardFirstBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        }
    }
}