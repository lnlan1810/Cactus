package com.example.android.cactus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Definition(
    @SerializedName("pos")
    val pos: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("tr")
    val tr: List<Translation>,
    @SerializedName("ts")
    val ts: String
)