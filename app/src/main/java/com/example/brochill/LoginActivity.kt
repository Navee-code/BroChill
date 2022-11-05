package com.example.brochill

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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
            email = binding.email.text.toString().trim()
            var password = binding.passwordLog.toString().trim()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.login(email, password)
            } else {
                Toast.makeText(this, "Fill the empty blocks", Toast.LENGTH_SHORT).show()
            }

        }
        viewModel.loginCredential.observe(this) {
            if (email == it.email) {
                sharedPreferences.setToken(it.token, this)
                sharedPreferences.setProfileId(it._id, this)
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
            }

        }
    }
}