package com.utkarshchoudhary.travelblogapplication

import android.content.Context

class BlogPreferences(context: Context) {

    private val preferences = context.getSharedPreferences("travel_blog", Context.MODE_PRIVATE)

    fun isLoggedIn(): Boolean {
        return preferences.getBoolean("KEY_LOGIN_STATE", false)
    }

    fun setLoggedIn(loggedIn: Boolean) {
        preferences.edit().putBoolean("KEY_LOGIN_STATE", loggedIn).apply()
    }

}