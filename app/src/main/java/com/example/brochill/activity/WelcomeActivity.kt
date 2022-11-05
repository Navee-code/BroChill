package com.example.brochill.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.brochill.HomeViewModel
import com.example.brochill.R
import com.example.brochill.SharedPreference
import com.example.brochill.databinding.ActivityMainBinding
import com.example.brochill.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var sharedPreferences: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences= SharedPreference()
        binding.button.visibility= View.GONE
        binding.textView.visibility=View.GONE
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getWelcome(sharedPreferences.getToken(this))
        binding.button.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        viewModel.welcome.observe(this){
                binding.textView.visibility=View.VISIBLE
                binding.button.visibility= View.VISIBLE
            binding.progressBar.visibility=View.GONE
            binding.imageView.visibility=View.VISIBLE
            Glide.with(this)
                .load(R.drawable.logo)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imageView)
              binding.textView.text=it?.message

        }
        viewModel.login.observe(this){
            binding.progressBar.visibility=View.GONE
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}