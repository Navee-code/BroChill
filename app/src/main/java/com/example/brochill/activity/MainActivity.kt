package com.example.brochill.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brochill.HomeViewModel
import com.example.brochill.SharedPreference
import com.example.brochill.TweetAdaptor
import com.example.brochill.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var sharedPreferences: SharedPreference
    private var tweets=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences= SharedPreference()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.tweet.setOnClickListener{
            startActivity(Intent(this, TweetActivity::class.java))
        }

       viewModel.getTweets(sharedPreferences.getToken(this))

         viewModel.getAllTweets.observe(this){
            for (i in 0 until it.size){
               tweets.add(it[i].tweet)
            }
             recyclerView(tweets)

}
    }
    private fun recyclerView(tweets: ArrayList<String>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        var  adapter=TweetAdaptor(tweets)
        binding.recyclerView.adapter = adapter
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
        super.onBackPressed()
    }
}