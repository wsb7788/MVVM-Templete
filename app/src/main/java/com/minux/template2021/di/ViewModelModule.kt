package com.minux.template2021.di

import com.minux.template2021.ui.login.LoginViewModel
import com.minux.template2021.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get(), get()) }
    viewModel { LoginViewModel(get(), get()) }
}