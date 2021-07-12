package com.minux.template2021.ui.splash

import android.content.Intent
import android.os.Bundle
import com.minux.template2021.MainActivity
import com.minux.template2021.R
import com.minux.template2021.data.entities.Auth
import com.minux.template2021.data.remote.auth.listeners.SplashListener
import com.minux.template2021.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : BaseActivity(), SplashListener {
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.splashListener = this
    }

    private fun startMainActivity(){
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        startActivity(intent)
        finish()
    }

//    private fun startLoginActivity(){
//        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
//        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//
//        startActivity(intent)
//        finish()
//    }


//    private fun startOnBoardingActivity(){
//        val intent = Intent(this@SplashActivity, OnBoardingActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
//        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//
//        startActivity(intent)
//        finish()
//    }

    override fun onStarted() {

    }

    override fun onAutoLoginSuccess(message: String) {
        startMainActivity()
    }

    override fun onAutoLoginSuccessWithChannelUrl(message: String, channelUrl: String) {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        intent.putExtra("groupChannelUrl",channelUrl)

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP) //푸시알람으로는 반드시 새로 activity 만들어야함

        startActivity(intent)
        finish()
    }

    override fun onAutoLoginFailure(code: Int, message: String) {
//        when(code){
//            304, 305 -> startMiracleActivity()
//            else -> startOnBoardingActivity()
//        }
    }

    override fun onGetVersionSuccess(auth: Auth) {
//        val version = BuildConfig.VERSION_NAME
//
//        if(!auth.isAvail){
//            mFlag = FLAG_SERVER_CHECK
//            showDialog(getString(R.string.dialog_title_server_check))
//            return
//        }
//
//        if(version != auth.androidVersion){
//            mFlag = FLAG_VERSION_UPDATE
//            showDialog(getString(R.string.dialog_title_version_update))
//            return
//        }
//
//        val channelUrl = intent.getStringExtra("groupChannelUrl")
//        if(channelUrl == null){
//            viewModel.autoLogin()
//        } else {
//            viewModel.autoLoginWithChannelUrl(channelUrl)
//        }
    }

    override fun onGetVersionFailure(code: Int, message: String) {
//        when(code){
//            404 -> {
//                mFlag = FLAG_NETWORK_ERROR
//                showDialog(getString(R.string.network_error))
//            }
//        }
    }

    override fun onOKClicked() {
//        when(mFlag){
//            FLAG_SERVER_CHECK,
//            FLAG_NETWORK_ERROR -> {
//
//                finish()
//            }
//
//            FLAG_VERSION_UPDATE -> {
//                val intent = Intent(Intent.ACTION_VIEW)
//                intent.data = Uri.parse("market://details?id=$packageName")
//                startActivity(intent)
//                finish()
//            }
//        }
    }
}