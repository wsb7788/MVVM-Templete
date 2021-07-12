package com.minux.template2021.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.minux.template2021.data.entities.User

class SharedPreferencesManager(private val context: Context){
    companion object{
        const val TAG = "MOBILE_TEMPLATE_APP"
        const val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
        const val USER = "USER"
    }

    fun getSharedPreferences() : SharedPreferences {
        return context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }

    fun removeAll(){
        val spf = getSharedPreferences()
        val editor = spf.edit()
        editor.remove(X_ACCESS_TOKEN)

        editor.apply()
    }

    fun saveUser(user: User){
        val spf = getSharedPreferences()
        val editor = spf.edit()
        val gson = Gson()
        val json = gson.toJson(user)
        editor.putString(USER, json)
        editor.apply()
    }

    fun getUser() : User? {
        val gson = Gson()
        val json = getSharedPreferences().getString(USER, null)

        return gson.fromJson(json, User::class.java)
    }

    fun removeUser(){
        val spf = getSharedPreferences()
        val editor = spf.edit()
        editor.remove(USER)
        editor.apply()
    }

    fun getJwtToken() : String? {
        return getSharedPreferences().getString(X_ACCESS_TOKEN, null)
    }

    fun saveJwtToken(jwtToken: String){
        val spf = getSharedPreferences()
        val editor = spf.edit()
        editor.putString(X_ACCESS_TOKEN, jwtToken)
        editor.apply()
    }

    fun removeJwtToken(){
        val spf = getSharedPreferences()
        val editor = spf.edit()
        editor.remove(X_ACCESS_TOKEN)
        editor.apply()
    }
}