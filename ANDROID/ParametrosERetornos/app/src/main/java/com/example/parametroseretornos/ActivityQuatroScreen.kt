package com.example.parametroseretornos

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityQuatroScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quatro_screen)

        val printedProdut = intent.getStringExtra("printedProdut")

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, ActivityQuatroResult::class.java)
            i.putExtra("printedProdut", printedProdut)
            startActivity(i)
            finish()
        }, 4000)

    }
}