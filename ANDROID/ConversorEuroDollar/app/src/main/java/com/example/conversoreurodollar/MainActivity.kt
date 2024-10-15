package com.example.conversoreurodollar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversoreurodollar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonEuroDollar.setOnClickListener {
            val eurosUtilizador: Double = binding.editEuros.text.toString().toDouble()
            val valorDollars = eurosUtilizador * 1.1
            binding.textDollars.text = "$valorDollars Dollars"
        }
        binding.buttonCelsius.setOnClickListener {
            val celsius: Double = binding.editCelsius.text.toString().toDouble()
            val valorFarhrenheit = celsius * 1.8 + 32
            binding.textFarhrenheit.text = "$valorFarhrenheit" + "ºF"
        }
    }
}