package com.example.android.cactus.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment

fun AppCompatActivity.findController(id: Int) =
    (supportFragmentManager.findFragmentById(id) as NavHostFragment)
        .navController
