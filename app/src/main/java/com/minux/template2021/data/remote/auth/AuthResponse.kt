package com.minux.template2021.data.remote.auth

import com.google.gson.annotations.SerializedName
import com.minux.template2021.data.entities.Auth

data class AuthResponse(
    @SerializedName(value = "isSuccess") val isSuccess : Boolean,
    @SerializedName(value = "code") val code : Int,
    @SerializedName(value = "message") val message : String,
    @SerializedName(value = "result") val auth : Auth?
)
