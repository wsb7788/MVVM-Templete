package com.minux.template2021.data.repository.auth

import com.minux.template2021.data.entities.User
import com.minux.template2021.data.remote.auth.AuthResponse
import com.minux.template2021.data.remote.auth.AuthService
import com.minux.template2021.data.repository.BaseRepository

class AuthRepository(private val authService: AuthService) : BaseRepository(){
    suspend fun signUp(user: User): AuthResponse {
        return apiRequest { authService.signUp(user) }
    }

    suspend fun login(user: User): AuthResponse {
        return apiRequest { authService.login(user) }
    }

    suspend fun autoLogin(): AuthResponse {
        return apiRequest { authService.autoLogin() }
    }

    suspend fun getVersion(): AuthResponse {
        return apiRequest { authService.getVersion() }
    }
}
