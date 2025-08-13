package com.anton.android_app_template

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anton.android_app_template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateStatus("onCreate()")
    }

    override fun onStart() {
        super.onStart()
        updateStatus("onStart()")
    }

    override fun onResume() {
        super.onResume()
        updateStatus("onResume()")
    }

    override fun onPause() {
        super.onPause()
        updateStatus("onPause()")
    }

    override fun onStop() {
        super.onStop()
        updateStatus("onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        updateStatus("onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        updateStatus("onDestroy()")
    }

    private fun updateStatus(method: String) {
        binding.statusText.text = "Текущий метод: $method"
        Log.d("Жизненный цикл", "$method")
        println("Жизненный цикл: $method") // Логи в Logcat
    }
}