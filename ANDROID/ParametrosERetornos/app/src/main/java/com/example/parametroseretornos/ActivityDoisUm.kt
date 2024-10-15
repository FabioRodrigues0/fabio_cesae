package com.example.parametroseretornos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parametroseretornos.databinding.ActivityDoisUmBinding

class ActivityDoisUm : AppCompatActivity() {
    private val binding by lazy {
        ActivityDoisUmBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSubmitDois.setOnClickListener {
            val number = binding.editNumberUm.text.toString()
            val i = Intent(this, ActivityDoisDois::class.java)
            i.putExtra("number", number)
            startActivity(i)
        }
    }
}