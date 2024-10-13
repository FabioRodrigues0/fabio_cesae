package com.example.parametroseretornos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parametroseretornos.databinding.ActivityUmBinding
import com.example.parametroseretornos.databinding.ActivityUmResultBinding

class ActivityUmResult : AppCompatActivity() {
    private val binding by lazy {
        ActivityUmResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        val name = i.extras?.getString("name")
        val email = i.extras?.getString("email")
        val phone = i.extras?.getString("phone")
        val address = i.extras?.getString("address")
        val gender = i.extras?.getString("gender")

        binding.textUmResult.text = "Nome : $name\nE-mail: $email\nTelefone: $phone\nMorada: $address\nGenero: $gender"

    }
}