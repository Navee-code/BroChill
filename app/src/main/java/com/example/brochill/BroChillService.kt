package com.example.brochill

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BroChillService {
    @GET("login")
   suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String,
   ): Response<LoginResponse>

    @GET("register")
    fun register(
        @Query("first_name") firstName: String,
        @Query("last_name") lastName: String,
        @Query("email") email: String,
        @Query("password") password: String
    ): Response<LoginResponse>

}