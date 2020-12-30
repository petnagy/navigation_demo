package com.petnagy.navigationdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.petnagy.navigationdemo.pages.data.DataFragment
import com.petnagy.navigationdemo.pages.more.MoreFragment
import com.petnagy.navigationdemo.pages.user.UserFragment
import kotlinx.android.synthetic.main.activity_dashboard.bottomNavView

class DashboardActivity: AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.dashboard_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        NavigationUI.setupWithNavController(bottomNavView, navHostFragment.navController)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        navController.navigateUp()
    }
}
