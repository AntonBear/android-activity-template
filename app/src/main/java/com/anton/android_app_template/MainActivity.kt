package com.anton.android_app_template

import android.os.Bundle
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

        // List
        val fruits: List<String> = listOf("test","test2","test3")
        val firstFruit = fruits[0]
//        fruits.add() -> ошибка

        // mutableListOf creates ArrayList under the hood
        val mutableFruit: MutableList<String> = mutableListOf("test")
        mutableFruit.add("test")
        mutableFruit[0] = "test"


        val arrayList: ArrayList<String> = arrayListOf<String>("test","test2")
        arrayList.add("test")
        arrayList[0] = "test"

        val array: Array<String> = arrayOf("test")
//        array.add() -> ошибка
        array[0] = "test"



        // | Тип           | Можно изменять? | Методы изменения                            |
        //| ------------- | --------------- | ------------------------------------------- |
        //| `List`        | Нет             | Нет (`add()`, `remove()` нет)               |
        //| `MutableList` | Да              | Есть (`add()`, `remove()`, `clear()` и др.) |


        val allFruits = StringBuilder()
        for (fruit in fruits) {
            allFruits.append(fruit).append("\n")
        }
        binding.textViewResult.text = allFruits.toString()

        val hasTest = "test" in fruits // true

        //Изменяемый список
        val mutableFruits = fruits.toMutableList()
        mutableFruits.add("test3")

    }

}