package com.example.brochill.response

data class GetTweetResponse(
    val tweets:List<String>,
    val __v: String,
    val _id: String,
    val tweet: String
)
