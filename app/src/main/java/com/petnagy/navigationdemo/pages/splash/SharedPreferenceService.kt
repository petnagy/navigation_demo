package com.petnagy.navigationdemo.pages.splash

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.petnagy.navigationdemo.services.PreferenceService

class SharedPreferenceService(context: Context): PreferenceService {

    companion object {
        private const val PREFERENCES = "userPreferences"

        private const val USER_EMAIL = "userEmail"
        private const val LOGGED_IN = "loggedIn"
    }

    private val sharedPref: SharedPreferences

    init {
        sharedPref = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun isLoggedIn(): Boolean {
        return sharedPref.getBoolean(LOGGED_IN, false)
    }

    override fun saveEmail(email: String) {
        sharedPref.edit {
            putString(USER_EMAIL, email)
        }
    }

    override fun checkEmail(email: String): Boolean {
        val savedEmail = sharedPref.getString(USER_EMAIL, "") ?: ""
        return savedEmail == email
    }

    override fun clearUserData() {
        sharedPref.edit {
            clear()
        }
    }

    override fun loggedInUser() {
        sharedPref.edit {
            putBoolean(LOGGED_IN, true)
        }
    }
}
