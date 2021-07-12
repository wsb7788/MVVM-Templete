package com.minux.template2021.di

import com.minux.template2021.data.repository.auth.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AuthRepository(get()) }
}