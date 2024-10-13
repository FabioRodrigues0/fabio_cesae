package com.example.exercicioalunos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exercicioalunos.databinding.ActivityAlunoDetailsBinding

class ActivityAlunoDetails : AppCompatActivity() {
    private val binding by lazy {
        ActivityAlunoDetailsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val aluno = intent.getStringExtra("aluno")
        binding.textResult.text = aluno

    }
}