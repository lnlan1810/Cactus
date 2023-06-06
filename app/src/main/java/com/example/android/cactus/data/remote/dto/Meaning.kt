package com.example.android.cactus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Meaning(
    @SerializedName("text")
    val text: String
)