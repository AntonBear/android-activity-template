package com.anton.android_app_template

import android.content.Intent
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
        binding.buttonNext.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        binding.buttonFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, SampleFragment())
                .addToBackStack(null) // чтобы можно было вернуться назад
                .commit()
        }
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
        Log.d("Activity lifeCycle", "MainActivity lifeCycle $method")
        println("Жизненный цикл: $method")
    }
}