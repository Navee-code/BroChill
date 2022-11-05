package com.example.brochill

import retrofit2.Response
import retrofit2.http.GET

interface BroChillService {
    @GET("app/login")
   fun getData(): Response<LoginResponse>

}