package com.example.exercicioalunos

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.exercicioalunos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listaAlunos = ArrayList<Aluno>()

        listaAlunos.addAll(listOf(
            Aluno("Fabio", "Rua da Um", "fabio@example-pet-store.com"),
            Aluno("João", "Rua da Dois", "joao@example-pet-store.com"),
            Aluno("Maria", "Rua da Tres", "maria@example-pet-store.com")))

        binding.listItems.adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listaAlunos)

        binding.listItems.setOnItemClickListener { parent, view, position, id ->
            val i = Intent(this, ActivityAlunoDetails::class.java)
            i.putExtra("aluno", listaAlunos[position].dadosAluno())
            startActivity(i)
        }

    }
}