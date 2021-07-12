package com.minux.template2021.di


import com.minux.template2021.utils.SharedPreferencesManager
import com.minux.template2021.utils.SharedPreferencesManager.Companion.X_ACCESS_TOKEN
import com.minux.template2021.data.remote.auth.AuthService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val PRODUCTION_URL = "http://13.209.10.30:3000/"
const val TEST_URL = "https://test.example.com/"
private val base_url: String = PRODUCTION_URL

fun getBaseUrl() = base_url

val networkModule: Module = module {
    fun provideHeaderInterceptor(sharedPreferenceManager: SharedPreferencesManager) =
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(X_ACCESS_TOKEN, "${sharedPreferenceManager.getJwtToken()}")
                .build()

            chain.proceed(request)
        }

    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY }

    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ) = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)


    single { provideHeaderInterceptor(get()) }
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get(), get()) }
    single { provideRetrofit(get()) }
    single { provideAuthService(get()) }
}