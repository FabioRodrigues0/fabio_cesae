package com.example.exercicioslistas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exercicioslistas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listUtilizadores = ArrayList<Utilizador>()

        listUtilizadores.add(Utilizador("admin", "admin"))
        listUtilizadores.add(Utilizador("user", "user"))
        listUtilizadores.add(Utilizador("fabio", "fabio"))

        binding.listItems.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listUtilizadores)

        binding.listItems.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, listUtilizadores.get(position).toString(), Toast.LENGTH_SHORT).show()
        }
    }
}