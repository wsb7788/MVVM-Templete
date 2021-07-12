package com.minux.template2021.data.remote.auth.listeners

import com.minux.template2021.data.entities.Auth


interface LoginListener {
    fun onLoginStarted()
    fun onLoginSuccess(auth: Auth)
    fun onLoginFailure(code: Int, message: String)
}