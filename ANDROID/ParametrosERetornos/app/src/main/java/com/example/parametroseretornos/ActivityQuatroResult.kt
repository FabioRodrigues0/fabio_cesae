package com.example.parametroseretornos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parametroseretornos.databinding.ActivityQuatroResultBinding

class ActivityQuatroResult : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuatroResultBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val printedProdut = intent.getStringExtra("printedProdut")
        binding.textQuatroResult.text = printedProdut

    }
}