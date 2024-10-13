package com.example.parametroseretornos

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.parametroseretornos.databinding.ActivityQuatroBinding
import java.util.Locale.filter

class ActivityQuatro : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuatroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSubmitQuatro.setOnClickListener {

            val list = listOf(
                verifyCheck(binding.produto1Check, binding.produto1Name, binding.produto1Price, binding.produto1Quantity),
                verifyCheck(binding.produto2Check, binding.produto2Name, binding.produto2Price, binding.produto2Quantity),
                verifyCheck(binding.produto3Check, binding.produto3Name, binding.produto3Price, binding.produto3Quantity))
            val filteredList = list.filter { it != "" }

            val screen = Intent(this, ActivityQuatroScreen::class.java)
            screen.putExtra("printedProdut", filteredList.joinToString())
            startActivity(screen)
        }
    }

    private fun verifyCheck(checkBox: CheckBox, produtName: TextView, price: TextView, quantity: EditText): String {
        if (checkBox.isChecked){
            val total = price.text.toString().toDouble() * quantity.text.toString().toDouble()
            val text = produtName.text.toString()
            return "$text: $total"
        }
        return ""
    }
}