package com.example.exerciciolistasnumeros

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.exerciciolistasnumeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listNumeros = ArrayList<Int>()
        listNumeros.addAll(listOf(1,2,3,4,5,6,7,8,9,10))

        binding.listItems.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listNumeros)

        binding.buttonAdicionar.setOnClickListener {
            val numero = binding.editNumero.text.toString().toInt()
            listNumeros.add(numero)
        }
    }
}