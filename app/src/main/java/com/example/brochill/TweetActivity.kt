package com.example.brochill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.brochill.databinding.ActivitySignUpBinding
import com.example.brochill.databinding.ActivityTweetBinding

class TweetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTweetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTweetBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}