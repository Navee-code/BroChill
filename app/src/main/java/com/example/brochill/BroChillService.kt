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
        @Query("email") email: String,
        @Query("password") password: String,
    ): Response<LoginResponse>

    @POST("register")
    suspend fun register(
        @Body dataModal: DataRegisterModel?
//        @Query("first_name") firstName: String,
//        @Query("last_name") lastName: String,
//        @Query("email") email: String,
//        @Query("password") password: String
    ): Response<LoginResponse>

}