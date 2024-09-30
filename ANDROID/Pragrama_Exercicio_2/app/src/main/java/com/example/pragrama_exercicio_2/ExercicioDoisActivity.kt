package com.example.pragrama_exercicio_2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pragrama_exercicio_2.databinding.ActivityExercicioDoisBinding

class ExercicioDoisActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityExercicioDoisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val username = binding.inputUsername.editText?.text.toString()
            val password = binding.inputPassword.editText?.text.toString()

            if (username.equals("user", ignoreCase = true) &&
                password.equals("pass", ignoreCase = true)) {
                val intent = Intent(this, LoginOk::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginError::class.java)
                startActivity(intent)
            }
        }
    }
}