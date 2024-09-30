package com.example.pragrama_exercicio_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pragrama_exercicio_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonExercicio1.setOnClickListener {
            val intent = Intent(this, ExercicioUmActivity::class.java)
            startActivity(intent)
        }
        binding.buttonExercicio2.setOnClickListener {
            val intent = Intent(this, ExercicioDoisActivity::class.java)
            startActivity(intent)
        }

        binding.buttonExercicio4.setOnClickListener {
            startActivity(Intent(this, ExercicioQuatroActivity::class.java))
        }
        binding.buttonExercicio5.setOnClickListener {
            startActivity(Intent(this, ExercicioCincoActivity::class.java))
        }
    }
}