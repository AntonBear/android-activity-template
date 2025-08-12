package com.anton.android_app_template

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anton.android_app_template.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val prefsName = "my_prefs"
    private val keyName = "user_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ///data/data/com.anton.android_app_template/shared_prefs/my_prefs.xml
//        String
//

//        Boolean
//
//        Float
//
//        Long
//
//        Set<String>
        val prefs = getSharedPreferences(prefsName, Context.MODE_PRIVATE)
        //        Int
        prefs.edit().putInt("int_key", 42).apply()
        //        Boolean
        prefs.edit().putBoolean("boolean_key", true).apply()
        //        Set<String>
        prefs.edit().putStringSet("set_key", setOf<String>("test","test1","test2")).apply()
        val savedName = prefs.getString(keyName, null)
        if (savedName != null) {
            binding.textViewResult.text = "$savedName"
        }
        binding.buttonSave.setOnClickListener {
            val name = binding.editTextName.text.toString()
            if (name.isNotEmpty()) {
                prefs.edit().putString(keyName,name).apply()
                binding.textViewResult.text = name
            }
        }
    }
}