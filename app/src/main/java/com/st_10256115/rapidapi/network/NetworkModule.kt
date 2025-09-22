package com.st_10256115.rapidapi.network

import com.st_10256115.rapidapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkModule {

    private val headers = Interceptor { chain ->
        val req = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", BuildConfig.RAPIDAPI_KEY)
            .addHeader("X-RapidAPI-Host", BuildConfig.RAPIDAPI_HOST)
            .build()
        chain.proceed(req)
    }

    private val log = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // set BASIC for release
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(headers)
        .addInterceptor(log)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}
