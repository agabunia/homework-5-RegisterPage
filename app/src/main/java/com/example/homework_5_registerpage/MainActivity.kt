package com.example.homework_5_registerpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_5_registerpage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val btnLogInMainPage = binding.btnLogInMainPage
        btnLogInMainPage.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        val btnRegisterMainPage = binding.btnRegisterMainPage
        btnRegisterMainPage.setOnClickListener {
            val intent = Intent(this, RegisterStepOneActivity::class.java)
            startActivity(intent)
        }
    }
}