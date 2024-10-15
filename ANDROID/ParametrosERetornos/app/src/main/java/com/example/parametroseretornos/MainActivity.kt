package com.example.parametroseretornos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parametroseretornos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonExUm.setOnClickListener {
            val i = Intent(this, ActivityUm::class.java)
            startActivity(i)
        }
        binding.buttonExDois.setOnClickListener {
            val i = Intent(this, ActivityDoisUm::class.java)
            startActivity(i)
        }
        binding.buttonExTres.setOnClickListener {

        }
        binding.buttonExQuatro.setOnClickListener {
            val i = Intent(this, ActivityQuatro::class.java)
            startActivity(i)
        }
        binding.buttonExCinco.setOnClickListener {

        }
    }
}