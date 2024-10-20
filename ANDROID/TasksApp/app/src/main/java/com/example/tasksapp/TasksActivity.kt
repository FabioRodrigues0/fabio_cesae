package com.example.tasksapp

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.tasksapp.databinding.ActivityTasksBinding

class TasksActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTasksBinding.inflate(layoutInflater)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("listTasks", Context.MODE_PRIVATE)
        val sharedProducts = sharedPreferences.getString("listTasks", "").toString()

        val listTasks = ArrayList<String>()

        val tasks = sharedProducts
            .replace("[", "")
            .replace("]", "")
            .replace("\"", "")
            .split(",")

        tasks.forEach {it -> listTasks.add(it.trim())}

        val listaTasksWithIndex = tasks.mapIndexed { index, value -> "$index -> $value" }
        binding.listTasks.adapter =
            ArrayAdapter(this,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaTasksWithIndex)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("listTasks", listTasks.toString())
        editor.apply()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        binding.buttonOpen.setOnClickListener {
            binding.buttonOpen.visibility = View.GONE
            binding.frameEdits.visibility = View.VISIBLE
            binding.frameEdits
                .animate()
                .translationY(0f)
                .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        }

        binding.buttonClose.setOnClickListener {
            binding.buttonOpen.visibility = View.VISIBLE
            binding.frameEdits
                .animate()
                .translationY(200f)
                .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
            binding.frameEdits.visibility = View.GONE
        }

        binding.buttonAddTask.setOnClickListener {
            val task = binding.textAddTask.text.toString()
            if (!listTasks.contains(task)) {
                listTasks.add(task)

                val listaTasksWithIndex = listTasks.mapIndexed { index, value -> "$index -> $value" }
                binding.listTasks.adapter =
                    ArrayAdapter(this,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaTasksWithIndex)

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("listTasks", listTasks.toString())
                editor.apply()
            } else {
                Toast.makeText(this, "Tarefa $task já se encontra na lista", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.textAddTask.text.clear()
        }

        binding.buttonRemoveTask.setOnClickListener {
            val task = binding.textRemoveTask.text.toString()
            if (listTasks.contains(task)) {
                val taskToRemove = listTasks.find { it.contains(task) }

                if (taskToRemove != null) {
                    listTasks.remove(taskToRemove)
                }

                val listaTasksWithIndex = listTasks.mapIndexed { index, value -> "$index -> $value" }
                binding.listTasks.adapter =
                    ArrayAdapter(this,  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaTasksWithIndex)

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("listTasks", listTasks.toString())
                editor.apply()
            } else {
                Toast.makeText(this, "Tarefa $task não encontrado", Toast.LENGTH_SHORT).show()
            }
            binding.textRemoveTask.text.clear()
        }

    }

}