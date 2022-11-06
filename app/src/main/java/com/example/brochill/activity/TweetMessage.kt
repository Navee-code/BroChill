package com.example.brochill.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.brochill.R

class TweetMessage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tweet_message)
        overridePendingTransition(R.anim.bottom_up, R.anim.nothing)
        val body=intent.getStringExtra("Body")
        val tweets=findViewById<TextView>(R.id.tweetMessage)
        tweets.text=body
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.nothing, R.anim.bottom_down)
    }
}