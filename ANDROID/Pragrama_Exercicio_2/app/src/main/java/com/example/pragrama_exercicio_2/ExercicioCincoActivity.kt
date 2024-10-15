package com.example.pragrama_exercicio_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pragrama_exercicio_2.databinding.ActivityExercicioCincoBinding
import com.example.pragrama_exercicio_2.databinding.ActivityExercicioQuatroBinding

class ExercicioCincoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityExercicioCincoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonConverter.setOnClickListener {
            val horas = binding.editHoras.editText?.text.toString().toInt()

            val semanas = horas / 168
            val dias = (horas % 168) / 24
            val horasRestantes = (horas % 168) % 24

            binding.textResult.text = "$semanas semanas, $dias dias e $horasRestantes horas."

        }
    }
}