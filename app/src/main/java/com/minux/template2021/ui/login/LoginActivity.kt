package com.minux.template2021.ui.login

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.minux.template2021.R
import com.minux.template2021.data.entities.Auth
import com.minux.template2021.data.remote.auth.listeners.LoginListener
import com.minux.template2021.databinding.ActivityLoginBinding
import com.minux.template2021.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity: BaseActivity(), LoginListener{

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.loginListener = this

        binding.loginLoginBtn.setOnClickListener (this)

    }

    override fun onClick(v: View?) {
        super.onClick(v)

        when(v){
            binding.loginLoginBtn ->viewModel.login()
        }
    }

    override fun onLoginStarted() {
        //로딩바
    }

    override fun onLoginSuccess(auth: Auth) {
        //로딩바 제거
        // ui를 뿌려주는 작업만 해야함
        //main화면으로 넘어가는 코드
    }

    override fun onLoginFailure(code: Int, message: String) {
        //로딩바 제거
        //실패에 대한 안내 팝업, 폼 아래에 경고문과 같은 작업을 해야 함
    }

}