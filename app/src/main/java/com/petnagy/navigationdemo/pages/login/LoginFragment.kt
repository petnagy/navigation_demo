package com.petnagy.navigationdemo.pages.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import com.petnagy.navigationdemo.pages.splash.SharedPreferenceService
import com.petnagy.navigationdemo.services.PreferenceService
import kotlinx.android.synthetic.main.fragment_login.emailAddressText
import kotlinx.android.synthetic.main.fragment_login.loginButton
import kotlinx.android.synthetic.main.fragment_login.signUpButton

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var preferenceService: PreferenceService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceService = SharedPreferenceService(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton.setOnClickListener {
            emailAddressText.error = null
            val email = emailAddressText.text.toString()
            if (email.isNotEmpty() && preferenceService.checkEmail(email)) {
                preferenceService.loggedInUser()
                findNavController().navigate(
                    R.id.action_loginFragment_to_dashboardActivity,
                    null,
                    NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
                )
                requireActivity().finish()
            } else {
                emailAddressText.error = getString(R.string.login_error)
            }
        }
        signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }
}
