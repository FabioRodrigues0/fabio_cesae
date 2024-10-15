package com.example.pragrama_exercicio_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pragrama_exercicio_2.databinding.ActivityExercicioDoisBinding
import com.example.pragrama_exercicio_2.databinding.ActivityExercicioQuatroBinding

class ExercicioQuatroActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityExercicioQuatroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonNumero.setOnClickListener {
            val numero1 = binding.inputNumero1.editText?.text.toString().toInt()

            if (numero1 % 2 == 0) {
                binding.textResultPar.text = "O numero é par"
            } else {
                binding.textResultPar.text = "O numero é impar"
            }
            if (numero1 % numero1 == 0){
                binding.textResultPrimo.text = "O numero é primo"
            } else {
                binding.textResultPrimo.text = "O numero não e primo"
            }
        }
    }
}