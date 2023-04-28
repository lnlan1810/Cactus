package com.example.android.cactus.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class Adj(
    val id: Int,
    val vocabulary: String,
    val mean:Int,
    val example:String,
    @DrawableRes val picture:Int,
    @RawRes val audio:Int
)

