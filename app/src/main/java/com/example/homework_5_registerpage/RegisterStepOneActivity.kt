package com.example.homework_5_registerpage

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.homework_5_registerpage.databinding.RegisterStep1ActivityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class RegisterStepOneActivity : AppCompatActivity() {
    private lateinit var binding: RegisterStep1ActivityBinding
    private lateinit var firebaseAuth : FirebaseAuth

    fun checkEmail(email: String): String {
        return if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ""
        } else {
            "Email is invalid!"
        }
    }
    fun checkPassword(password: String): String {
        return if(password.length >= 8) {
            ""
        } else {
            "Password is too short!"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterStep1ActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firebaseAuth = FirebaseAuth.getInstance()

        val btnReturnToMain = binding.btnReturnToMain
        btnReturnToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var errorText = binding.tvErrorText
        val btnNext = binding.btnNext
        btnNext.setOnClickListener {
            var email = binding.etMailRegisterPage.text.toString()
            var password = binding.etPasswordRegisterPage.text.toString()
            var mailChecked = checkEmail(email)
            var passwordChecked = checkPassword(password)
            if(mailChecked == "" && passwordChecked == "") {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if(it.isSuccessful) {
                        val intent = Intent(this, RegisterStepTwoActivity::class.java)
                        startActivity(intent)
                    } else {
                        errorText.text = "User was not added"
                    }
                }
            } else {
                errorText.text = "$mailChecked \n$passwordChecked"
            }
        }
    }
}