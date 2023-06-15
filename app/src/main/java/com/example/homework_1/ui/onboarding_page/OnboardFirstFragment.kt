package com.example.homework_1.ui.onboarding_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentOnboardFirstBinding
import com.example.homework_1.ui.onboarding_page.onboarding_adapter.OnboardingAdapter
import com.example.homework_1.ui.sign_up_page.SignUpFragment
import com.example.homework_1.util.replaceFragment

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

        binding.skipButton.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, SignUpFragment())
        }

        binding.viewPager.adapter = OnboardingAdapter(parentFragmentManager)
        binding.circleIndicator.setViewPager(binding.viewPager)
    }
}
