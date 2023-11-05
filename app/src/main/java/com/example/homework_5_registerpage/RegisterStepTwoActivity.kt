package com.example.homework_5_registerpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_5_registerpage.databinding.RegisterStep2ActivityBinding

class RegisterStepTwoActivity : AppCompatActivity() {
    private lateinit var binding: RegisterStep2ActivityBinding

    fun checkUsername(username: String): String {
        return if(username.length >= 8) {
            ""
        } else {
            "Username is too short!"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterStep2ActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnReturnToRegister = binding.btnReturnToRegister
        btnReturnToRegister.setOnClickListener{
            val intent = Intent(this, RegisterStepOneActivity::class.java)
            startActivity(intent)
        }

        var errorText = binding.tvErrorText
        val btnSignUp = binding.btnSignUp
        btnSignUp.setOnClickListener {
            var username = binding.etUsername.text.toString()
            var usernameChecked = checkUsername(username)
            if(usernameChecked == "") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                errorText.text = "$usernameChecked"
            }
        }

    }
}