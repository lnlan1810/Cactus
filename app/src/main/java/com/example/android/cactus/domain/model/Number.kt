package com.example.android.cactus.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class Number(
    val id: Int,
    val num: String,
    val text: String,
    val mean: String,
    @DrawableRes val picture:Int,
    @RawRes val audio:Int
)
