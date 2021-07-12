package com.minux.template2021.data.remote.auth.listeners

import com.minux.template2021.data.entities.Auth

interface SplashListener {
    fun onStarted()
    fun onAutoLoginSuccess(message: String)
    fun onAutoLoginFailure(code: Int, message: String)
    fun onAutoLoginSuccessWithChannelUrl(message:String, channelUrl:String)

    fun onGetVersionSuccess(auth: Auth)
    fun onGetVersionFailure(code: Int, message: String)
}