package com.petnagy.navigationdemo.services

interface PreferenceService {
    fun isLoggedIn(): Boolean

    fun saveEmail(email: String)

    fun checkEmail(email: String): Boolean

    fun clearUserData()

    fun loggedInUser()
}
