package com.example.brochill.api

import com.example.brochill.dataclass.DataCreateTweet
import com.example.brochill.dataclass.DataLogin
import com.example.brochill.dataclass.DataRegisterModel
import com.example.brochill.response.WelcomeData
import com.example.brochill.response.LoginResponse
import com.example.brochill.response.ResponseGetTweets
import com.example.brochill.response.ResponseTweet
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