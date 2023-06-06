package com.example.android.cactus.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.android.cactus.R
import com.example.android.cactus.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = findController(R.id.fragment)

        if (savedInstanceState != null) {
            return
        }
        //setContentView(R.layout.activity_main)
        controller =
            (supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment).navController

        val bottomView = binding!!.bottomNavigationView
        bottomView.setupWithNavController(controller!!)

        supportFragmentManager.beginTransaction()
    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.fragment)
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}
