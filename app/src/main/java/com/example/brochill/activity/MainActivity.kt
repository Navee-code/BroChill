package com.example.brochill.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brochill.viewmodel.HomeViewModel
import com.example.brochill.R
import com.example.brochill.SharedPreference
import com.example.brochill.adapter.TweetAdaptor
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
            for (i in it.size-1 downTo 0){
               tweets.add(it[i].tweet)
            }
             recyclerView(tweets)

}
    }
    private fun recyclerView(tweets: ArrayList<String>) {
        binding.progressBar2.visibility=View.GONE
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        var  adapter= TweetAdaptor(tweets)
        binding.recyclerView.adapter = adapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.logout_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

      sharedPreferences.setToken("",this)
        startActivity(Intent(this, LoginActivity::class.java))
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
        super.onBackPressed()
    }
}