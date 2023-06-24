package com.puc.telias.githubapp.webclient

import com.puc.telias.githubapp.webclient.services.GitHubUserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitConfig {
    private val client by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/users/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val gitHubUserService = retrofit.create(GitHubUserService::class.java)
}