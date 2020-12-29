package com.petnagy.navigationdemo.pages.splash

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import com.petnagy.navigationdemo.common.wait
import com.petnagy.navigationdemo.services.PreferenceService

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var prefereneService: PreferenceService

    override fun onResume() {
        super.onResume()
        prefereneService = SharedPreferenceService(requireContext())
        if (prefereneService.isLoggedIn()) {
            findNavController().navigate(R.id.dashboardActivity, null, NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build())
            requireActivity().finish()
        } else {
            wait(2000) {
                findNavController().navigate(
                    R.id.action_splashFragment_to_loginFragment, null,
                    NavOptions.Builder().setPopUpTo(R.id.splashFragment, true).build()
                )
            }
        }
    }
}
