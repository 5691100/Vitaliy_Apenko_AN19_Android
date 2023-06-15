package com.example.homework_1.ui.sign_up_page

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentLogInBinding
import com.example.homework_1.databinding.FragmentSignUpBinding
import com.example.homework_1.model.User
import com.example.homework_1.ui.log_in_page.LogInFragment
import com.example.homework_1.util.getString
import com.example.homework_1.util.replaceFragment

class SignUpFragment : Fragment() {

    private val viewModel: SignUpViewModel by viewModels()

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.run {
            userSaved = {
                Toast.makeText(requireContext(), "Sign-Up successful", Toast.LENGTH_LONG).show()
                parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), true)
            }
        }

        binding.signUpButton.setOnClickListener {
            addUser()
        }

        binding.loginAsk.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, LogInFragment(), true)
        }
    }

    private fun addUser() {
        viewModel.addNewUser(
            User(
                binding.firstNameEditText.getString(),
                binding.secondNameEditText.getString(),
                binding.emailEditText.getString(),
                binding.passwordEditText.getString()
            )
        )
    }
}