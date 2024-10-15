package com.example.parametroseretornos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parametroseretornos.databinding.ActivityDoisDoisBinding
import com.example.parametroseretornos.databinding.ActivityDoisUmBinding

class ActivityDoisDois : AppCompatActivity() {
    private val binding by lazy {
        ActivityDoisDoisBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        val number1 = i.extras?.getString("number")


    }
}