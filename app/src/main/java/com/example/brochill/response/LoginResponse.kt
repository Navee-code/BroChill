package com.example.brochill.response

data class LoginResponse(
    val _id: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val token: String)