package com.minux.template2021.data.remote.auth

import com.minux.template2021.data.entities.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("users/signup")
    suspend fun signUp(@Body user: User): Response<AuthResponse>

    @POST("users/login")
    suspend fun login(@Body user: User): Response<AuthResponse>

    @GET("users/autologin")
    suspend fun autoLogin(): Response<AuthResponse>

    @GET("version")
    suspend fun getVersion(): Response<AuthResponse>
}
