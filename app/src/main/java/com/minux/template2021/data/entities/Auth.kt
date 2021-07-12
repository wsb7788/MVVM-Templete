package com.minux.template2021.data.entities

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName(value = "jwt") val jwtToken: String?,
    @SerializedName(value = "fcmToken") val fcmToken: String?,
    @SerializedName(value = "nickname") val nickname: String = "",
    @SerializedName(value = "profileImg") val profileImg: String = "",
    @SerializedName(value = "isNotice") val isNotice: Int = 0,
    @SerializedName(value = "androidVersion") val androidVersion: String = "",
    @SerializedName(value = "iosVersion") val iosVersion: String = "",
    @SerializedName(value = "isAvail") val isAvail: Boolean = true,
    @SerializedName(value = "authenticNum") val authenticNum: Int = 0
)
