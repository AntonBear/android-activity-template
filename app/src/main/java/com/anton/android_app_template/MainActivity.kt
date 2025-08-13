package com.anton.android_app_template

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.anton.android_app_template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        updateStatus("start onCreate()")

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получаем NavController из NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Логируем при каждом изменении экрана
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val destId = destination.id
            val destName = try {
                resources.getResourceEntryName(destId) // вернёт имя из nav_graph
            } catch (e: Exception) {
                "unknown"
            }
            Log.d("NavController", "Текущий экран: $destName")
            logNavControllerStackCompat()
            logFragmentManager()
        }
        updateStatus("end onCreate()")

    }

    // Логирование FragmentManager
    private fun logFragmentManager() {
        // Внешний FragmentManager (Activity)
        val outerFragments = supportFragmentManager.fragments.map { it::class.java.simpleName }
        Log.d("FragmentManagerState", "Fragments в SupportFragmentManager (внешний уровень): $outerFragments")

        // Внутренний FragmentManager (NavHostFragment)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val innerFragments = navHostFragment.childFragmentManager.fragments.map { it::class.java.simpleName }
        Log.d("FragmentManagerState", "Fragments внутри NavHostFragment (внутренний уровень): $innerFragments")
    }

    // Логирование стека NavController
    private fun logNavControllerStackCompat() {
        val stackStrings = navController.backQueue.map { entry ->
            val name = entry.destination.label?.toString() ?: try {
                resources.getResourceEntryName(entry.destination.id)
            } catch (e: Exception) {
                "unknown"
            }
            name
        }

        Log.d("NavBackStack", "NavController BackStack: $stackStrings")
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
        Log.d("FragmentLifeCycle", "MainActivity lifeCycle $method")
    }
}
