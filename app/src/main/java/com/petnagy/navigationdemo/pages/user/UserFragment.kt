package com.petnagy.navigationdemo.pages.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petnagy.navigationdemo.R
import com.petnagy.navigationdemo.pages.splash.SharedPreferenceService
import com.petnagy.navigationdemo.services.PreferenceService
import kotlinx.android.synthetic.main.fragment_user.logoutButton

class UserFragment: Fragment(R.layout.fragment_user) {

    private lateinit var preferenceService: PreferenceService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferenceService = SharedPreferenceService(requireContext())
        logoutButton.setOnClickListener {
            preferenceService.clearUserData()
            findNavController().navigate(R.id.mainActivity)
            requireActivity().finish()
        }
    }
}
