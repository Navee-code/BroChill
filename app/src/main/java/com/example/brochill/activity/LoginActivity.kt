package com.example.brochill.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.brochill.viewmodel.HomeViewModel
import com.example.brochill.SharedPreference
import com.example.brochill.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: HomeViewModel
    private var email: String = ""
    private lateinit var sharedPreferences: SharedPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = SharedPreference()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.register.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        binding.login.setOnClickListener {
            binding.progressCircular.visibility=View.VISIBLE
            email = binding.email.text.toString().trim()
            var password=binding.passwordLog.text.toString().trim()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.login(email, password)
            } else {
                binding.progressCircular.visibility=View.GONE
                Toast.makeText(this, "Fill the empty blocks", Toast.LENGTH_SHORT).show()
            }

        }
        viewModel.credentials.observe(this){
            binding.progressCircular.visibility=View.GONE
            Toast.makeText(this, "Wrong Entries", Toast.LENGTH_SHORT).show()
        }
        viewModel.loginCredential.observe(this) {

                if (email == it.email) {
                    binding.progressCircular.visibility=View.GONE
                    sharedPreferences.setToken(it.token, this)
                    startActivity(Intent(this, MainActivity::class.java))
                }


        }
    }



    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(a)
        super.onBackPressed()
    }
}