package com.petnagy.navigationdemo.pages.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import com.petnagy.navigationdemo.pages.splash.SharedPreferenceService
import com.petnagy.navigationdemo.services.PreferenceService
import kotlinx.android.synthetic.main.fragment_signup.signupButton
import kotlinx.android.synthetic.main.fragment_signup.signupEmailAddressText

class SignUpFragment : Fragment(R.layout.fragment_signup) {

    private lateinit var preferenceService: PreferenceService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferenceService = SharedPreferenceService(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signupEmailAddressText.error = null
        signupButton.setOnClickListener {
            val email = signupEmailAddressText.text.toString()
            if (email.isNotEmpty()) {
                preferenceService.saveEmail(email)
                findNavController().navigate(
                    R.id.action_signUpFragment_to_loginFragment,
                    null,
                    NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
                )
            } else {
                signupEmailAddressText.error = getString(R.string.signup_error)
            }
        }
    }
}
