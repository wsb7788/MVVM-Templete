package com.minux.template2021.data.remote.auth

import com.google.gson.annotations.SerializedName
import com.minux.template2021.data.entities.Auth

data class AuthResponse(
    @SerializedName(value = "check") val check : Boolean,
    @SerializedName(value = "code") val code : Int,
    @SerializedName(value = "id") val id : String,
    @SerializedName(value = "password") val password : String,
    @SerializedName(value = "message") val message : String,
    @SerializedName(value = "nickname") val nickname : String,
    @SerializedName(value = "auth") val auth : Auth?,
)
