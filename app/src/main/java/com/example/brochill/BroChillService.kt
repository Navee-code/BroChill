package com.example.brochill

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface BroChillService {
    @POST("login")
   suspend fun login(
        @Body dataModal: DataLogin?
    ): Response<LoginResponse>

    @POST("register")
    suspend fun register(
        @Body dataModal: DataRegisterModel?
    ): Response<LoginResponse>


    @POST("tweets")
    suspend fun createTweet(
        @Body dataModal: DataCreateTweet?
    ): Response<ResponseTweet>

    @GET("tweets")
    suspend fun getTweet(
    ):Response<ResponseGetTweets>

    @GET("welcome")
       suspend fun getWelcome(
       ):Response<WelcomeData>
}