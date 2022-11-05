package com.example.brochill.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.brochill.HomeViewModel
import com.example.brochill.SharedPreference
import com.example.brochill.databinding.ActivityTweetBinding

class TweetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTweetBinding
    private lateinit var sharedPreferences: SharedPreference
    private lateinit var viewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = SharedPreference()
        binding= ActivityTweetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.post.setOnClickListener{
            var message=binding.createTweet.text.toString().trim()
            if(message.isNotEmpty()){
                viewModel.createTweet(sharedPreferences.getToken(this).toString(),message)
                Toast.makeText(this, "Tweet Posted", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
    }
}