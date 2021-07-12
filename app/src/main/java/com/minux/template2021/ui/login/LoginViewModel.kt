package com.minux.template2021.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minux.template2021.data.entities.User
import com.minux.template2021.data.remote.auth.listeners.LoginListener
import com.minux.template2021.data.repository.auth.AuthRepository
import com.minux.template2021.utils.ApiException
import com.minux.template2021.utils.Coroutines
import com.minux.template2021.utils.SharedPreferencesManager
import kotlinx.coroutines.delay

class LoginViewModel(private val repository: AuthRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel() {
    var loginListener: LoginListener? = null
    val id: MutableLiveData<String> by lazy{
        MutableLiveData<String>().apply {
            postValue("")
        }
    }
    val pw: MutableLiveData<String> by lazy{
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    private fun getUser(): User = User(id=id.value.toString(),pw=pw.value.toString())


    fun login() {
        loginListener?.onLoginStarted()

        val user = getUser()
        Log.d("login-test","$user")


        Coroutines.main {
            try {
                val authResponse = repository.login(getUser())

                Log.d("login-test","$authResponse")


                if(authResponse.check) {
                    authResponse.auth?.let {
                        loginListener?.onLoginSuccess(authResponse.auth)
                        sharedPreferencesManager.saveJwtToken(authResponse.auth.jwtToken!!)

                        return@main
                    }
                }else{
                    loginListener?.onLoginFailure(authResponse.code, authResponse.message)
                }
            } catch (e: ApiException) {
                loginListener?.onLoginFailure(404, e.message!!)
            } catch (e: Exception){
                loginListener?.onLoginFailure(404, e.message!!)
            }
        }
    }

}