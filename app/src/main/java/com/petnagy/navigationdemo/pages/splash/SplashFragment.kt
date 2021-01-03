package com.petnagy.navigationdemo.pages.splash

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import com.petnagy.navigationdemo.common.wait
import com.petnagy.navigationdemo.services.PreferenceService

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var preferenceService: PreferenceService

    override fun onResume() {
        super.onResume()
        preferenceService = SharedPreferenceService(requireContext())
        if (preferenceService.isLoggedIn()) {
            findNavController().navigate(R.id.action_splashFragment_to_dashboardActivity, null, NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_left)
                .setExitAnim(R.anim.slide_out_left)
                .setPopUpTo(R.id.loginFragment, true).build())
            requireActivity().finish()
        } else {
            wait(2000) {
                findNavController().navigate(
                    R.id.action_splashFragment_to_loginFragment, null,
                    NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_left)
                        .setExitAnim(R.anim.slide_out_left)
                        .setPopUpTo(R.id.splashFragment, true).build()
                )
            }
        }
    }
}
