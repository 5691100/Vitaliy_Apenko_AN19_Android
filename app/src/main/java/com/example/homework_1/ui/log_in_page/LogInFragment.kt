package com.example.homework_1.ui.log_in_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.homework_1.R
import com.example.homework_1.databinding.FragmentLogInBinding
import com.example.homework_1.repositories.SharedPreferenceRepository
import com.example.homework_1.ui.notes_list.NavigationFragment
import com.example.homework_1.ui.sign_up_page.SignUpFragment
import com.example.homework_1.util.getString
import com.example.homework_1.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : Fragment() {

    private val viewModel: LogInViewModel by viewModels()

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.logInButton.setOnClickListener {
            val email = binding.emailEditText.getString()
            val password = binding.passwordEditText.getString()
            viewModel.run {
                checkLogin(email, password)
                isPasswordCorrect = {
                    binding.root.post {
                        parentFragmentManager.replaceFragment(
                            R.id.container,
                            NavigationFragment(),
                            false
                        )
                        Toast.makeText(requireContext(), "LogIn successful!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                isPasswordIncorrect = {
                    binding.root.post {
                        Toast.makeText(requireContext(), "Incorrect password!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
                isUserNotExist = {
                    binding.root.post {
                        Toast.makeText(requireContext(), "User doesn't exist!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        binding.returnToSignUp.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.container, SignUpFragment(), true)
        }
    }
}