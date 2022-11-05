package com.example.brochill

import android.content.Context
import android.content.SharedPreferences

class SharedPreference {
    fun setToken(token: String,context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putString("taken",token)
        editor.apply()
        editor.commit()
    }
        fun getToken(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE)

        val token = sharedPreferences.getString("taken","")
            return token
    }
    fun setProfileId(token: String,context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor =  sharedPreferences.edit()
        editor.putString("taken",token)
        editor.apply()
        editor.commit()
    }
    fun getProfileId(context: Context): String? {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("session", Context.MODE_PRIVATE)

        val token = sharedPreferences.getString("taken","")
        return token
    }
}