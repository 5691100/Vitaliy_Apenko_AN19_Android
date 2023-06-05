package com.example.homework_1.ui.onboarding_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentOnboardStepBinding


const val STEP_1 = 1
const val STEP_2 = 2
const val STEP_3 = 3

private const val STEP_EXTRA = "stepExtra"

class OnboardStepFragment : Fragment() {

    private lateinit var binding: FragmentOnboardStepBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val step = arguments?.getInt(STEP_EXTRA) ?: STEP_1
        when (step) {
            STEP_1 -> {
                binding.titleTextView.setText(R.string.onboarding_step_1_text)

            }
            STEP_2 -> {
                binding.titleTextView.setText(R.string.onboarding_step_2_text)

            }
            STEP_3 -> {
                binding.titleTextView.setText(R.string.onboarding_step_3_text)

            }
        }
    }

    companion object {

        fun getOnboardingStepFragment(stepNumber: Int): OnboardStepFragment {
            return OnboardStepFragment().apply {
                arguments = bundleOf(STEP_EXTRA to stepNumber)
            }
        }
    }
}