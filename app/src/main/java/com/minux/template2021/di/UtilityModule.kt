package com.minux.template2021.di

import com.minux.template2021.utils.GlobalConstant
import com.minux.template2021.utils.SharedPreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val utilityModule = module {
    single { SharedPreferencesManager(androidContext()) }
    single { GlobalConstant() }
}