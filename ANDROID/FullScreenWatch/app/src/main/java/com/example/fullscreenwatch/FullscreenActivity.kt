package com.example.fullscreenwatch

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import com.example.fullscreenwatch.databinding.ActivityFullscreenBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class FullscreenActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFullscreenBinding.inflate(layoutInflater)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.addFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        binding.checkboxBattery.setOnClickListener {
            val isCheck = binding.checkboxBattery.isChecked

            if (isCheck){
                val bateriaReceiber: BroadcastReceiver = object : BroadcastReceiver(){
                    override fun onReceive(p0: Context?, intent: Intent?) {
                        if (intent != null) {
                            val nivel: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                            binding.textBattery.visibility = View.VISIBLE
                            binding.textBattery.text = nivel.toString()+'%'
                        }
                    }
                }
                registerReceiver(bateriaReceiber, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
            } else{
                binding.textBattery.visibility = View.GONE
            }
        }

        binding.buttonTool.setOnClickListener {
            binding.buttonTool.visibility = View.GONE
            binding.fullscreenContentControls
                .animate()
                .translationY(0f)
                .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        }

        binding.buttonClose.setOnClickListener {
            binding.buttonTool.visibility = View.VISIBLE
            binding.fullscreenContentControls
                .animate()
                .translationY(150f)
                .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
        }
    }

}