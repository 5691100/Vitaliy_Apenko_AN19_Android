package com.example.homework_1.ui.onboarding_page.onboarding_adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.homework_1.ui.onboarding_page.OnboardStepFragment
import com.example.homework_1.ui.onboarding_page.OnboardStepFragment.Companion.getOnboardingStepFragment
import com.example.homework_1.ui.onboarding_page.STEP_1
import com.example.homework_1.ui.onboarding_page.STEP_2
import com.example.homework_1.ui.onboarding_page.STEP_3

class OnboardingAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val listFragment =
        arrayListOf(
            getOnboardingStepFragment(STEP_1),
            getOnboardingStepFragment(STEP_2),
            getOnboardingStepFragment(STEP_3)
        )

    override fun getCount() = listFragment.size

    override fun getItem(position: Int): Fragment = listFragment[position]
}
