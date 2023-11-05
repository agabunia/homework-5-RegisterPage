package com.example.homework_5_registerpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_5_registerpage.databinding.LogInActivityBinding
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: LogInActivityBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firebaseAuth = FirebaseAuth.getInstance()


        val btnReturnToMain = binding.btnReturnToMain
        btnReturnToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val errorText = binding.tvErrorText
        val btnLogInLogPage = binding.btnLogInLogPage
        btnLogInLogPage.setOnClickListener {
            var email = binding.etMailLoginPage.text.toString()
            var password = binding.etPasswordLoginPage.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        errorText.text = "Log in failed"
                    }
                }
            }
        }
    }
}