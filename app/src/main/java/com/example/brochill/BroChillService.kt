package com.example.brochill

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BroChillService {
    @POST("login")
   suspend fun login(
        @Body dataModal: DataLogin?
    ): Response<LoginResponse>

    @POST("register")
    suspend fun register(
        @Body dataModal: DataRegisterModel?
    ): Response<LoginResponse>

}