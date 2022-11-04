package com.example.brochill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brochill.databinding.ActivityMainBinding
import com.example.brochill.databinding.ActivityTweetBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tweet.setOnClickListener{
            startActivity(Intent(this,TweetActivity::class.java))
        }

    }
}