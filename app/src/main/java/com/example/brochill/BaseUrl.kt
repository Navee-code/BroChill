package com.example.brochill

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseUrl {
    val URL = "https://wern-api.brochill"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL)
            .build()
    }
}