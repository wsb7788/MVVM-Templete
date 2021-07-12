package com.minux.template2021.data.entities

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "id") val id: String = "",
    @SerializedName(value = "email") val email: String = "",
    @SerializedName(value = "pw") val pw: String = "",
    @SerializedName(value = "profileImg") val profileImg: String = "",
    @SerializedName(value = "nickname") val nickname: String = "",
    @SerializedName(value = "gender") val gender: String = "",
    @SerializedName(value = "birthday") val birthday: String = "",
    @SerializedName(value = "isIos") val isIos: String = "N",
    @SerializedName(value = "isRegister") var isRegister: String = "N"
)
