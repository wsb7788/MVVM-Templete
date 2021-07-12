package com.minux.template2021

import android.app.Application
import com.minux.template2021.di.networkModule
import com.minux.template2021.di.repositoryModule
import com.minux.template2021.di.utilityModule
import com.minux.template2021.di.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.BuildConfig.DEBUG
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationClass : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            if (DEBUG) {
                androidLogger()
            } else {
            androidLogger(Level.NONE)
        }
            androidContext(this@ApplicationClass)
            modules(
                utilityModule,
                viewModelModule,
                networkModule,
                repositoryModule
            )
        }
    }
}