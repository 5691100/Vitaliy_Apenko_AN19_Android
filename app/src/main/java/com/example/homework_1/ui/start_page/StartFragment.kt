package com.example.homework_1.ui.start_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentStartBinding
import com.example.homework_1.ui.log_in_page.LogInFragment
import com.example.homework_1.ui.onboarding_page.OnboardFirstFragment
import com.example.homework_1.ui.sign_up_page.SignUpFragment
import com.example.homework_1.util.replaceFragment

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.onboardingButton.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, OnboardFirstFragment(), true)
        }

        binding.accountAsk.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, SignUpFragment(), true)
        }

        binding.loginAsk.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), true)
        }
    }
}