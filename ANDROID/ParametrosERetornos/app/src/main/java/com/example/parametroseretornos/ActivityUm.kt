package com.example.parametroseretornos

import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.core.view.get
import com.example.parametroseretornos.databinding.ActivityMainBinding
import com.example.parametroseretornos.databinding.ActivityUmBinding

class ActivityUm : AppCompatActivity() {
    private val binding by lazy {
        ActivityUmBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var gender = "";

        binding.radioGender.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.radioFemale.id -> {
                    gender = "Feminino"
                }
                binding.radioMale.id -> {
                    gender = "Masculino"
                }
            }
        }

        binding.buttonSubmit.setOnClickListener {
            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val phone = binding.editPhone.text.toString()
            val address = binding.editAddress.text.toString()

            val i = Intent(this, ActivityUmResult::class.java)
            i.putExtra("name", name)
            i.putExtra("email", email)
            i.putExtra("phone", phone)
            i.putExtra("address", address)
            i.putExtra("gender", gender)
            startActivity(i);
        }
    }
}