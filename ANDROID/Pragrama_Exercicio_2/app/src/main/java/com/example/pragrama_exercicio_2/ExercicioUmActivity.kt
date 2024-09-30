package com.example.pragrama_exercicio_2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pragrama_exercicio_2.databinding.ActivityExercicioUmBinding

class ExercicioUmActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityExercicioUmBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
        }

        binding.buttonNavigation.setOnClickListener {
            val intent = Intent(this, ExercicioUmSaudacoes::class.java)
            startActivity(intent)
        }
    }
}