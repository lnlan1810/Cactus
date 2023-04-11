package com.example.android.cactus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android.cactus.databinding.ActivityMainBinding
import com.example.android.cactus.homeScreen.findController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var controller: NavController


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = findController(R.id.fragment)

        if(savedInstanceState !=null) {
            return
        }
        //setContentView(R.layout.activity_main)
        controller = (supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment).navController

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomView.setupWithNavController(controller)

    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.fragment)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}