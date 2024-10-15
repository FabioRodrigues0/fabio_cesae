package com.example.sharedlist

import android.R
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.system.Os.remove
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("listNotes", Context.MODE_PRIVATE)
        val sharedNotes = sharedPreferences.getString("listNotes", "").toString()

        val listNotes = ArrayList<String>()
        val notes = sharedNotes
            .replace("[", "")
            .replace("]", "")
            .split(",")

        notes.forEach {
            listNotes.add(it.trim())
        }

        binding.listNotes.adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listNotes)

        binding.buttonSubmitNote.setOnClickListener {
            val note = binding.textNote.text.toString()
            listNotes.add(note)
            binding.listNotes.adapter = ArrayAdapter(this, R.layout.simple_list_item_1, listNotes)

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("listNotes", listNotes.toString())
            editor.apply()
        }

    }
}