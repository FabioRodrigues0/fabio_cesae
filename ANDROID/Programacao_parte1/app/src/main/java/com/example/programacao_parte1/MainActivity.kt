package com.example.programacao_parte1

import android.os.Build.VERSION_CODES.S
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.programacao_parte1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.contentMain.buttonLabelOla.setOnClickListener {
            val firstName = binding.contentMain.textInputFirstName.editText?.text.toString()
            val lastName = binding.contentMain.textInputLastName.editText?.text.toString()

            binding.contentMain.textOla.text = String.format("Olá $S  $S", firstName, lastName)
        }

        binding.contentMain.buttonPopOla.setOnClickListener {
            val firstName = binding.contentMain.textInputFirstName.editText?.text.toString()
            val lastName = binding.contentMain.textInputLastName.editText?.text.toString()

            Toast.makeText(applicationContext, "Olá $firstName $lastName"
                , Toast.LENGTH_SHORT).show()
        }
    }

}