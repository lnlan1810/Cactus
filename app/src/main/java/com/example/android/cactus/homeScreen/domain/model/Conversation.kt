package com.example.android.cactus.homeScreen.domain.model
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes

data class Conversation(
    val id: Int,
  val dia: Int,
  val tema:String,
  val text:String,
  @DrawableRes val picture:Int,
  @RawRes val audio:Int
  )
