package com.example.brochill.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BaseUrl{
    val URL = "https://wern-api.brochill.app"

    fun getInstance(token: String?): Retrofit {
       var builder=OkHttpClient.Builder()
        builder.addInterceptor(object :Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
               var request = chain.request().newBuilder().addHeader("x-api-key", token.toString()).build();
                return chain.proceed(request);
            }

        })

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
            .baseUrl(URL)

            .build()
    }


}