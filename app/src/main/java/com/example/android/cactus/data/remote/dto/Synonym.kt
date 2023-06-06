package com.example.android.cactus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Synonym(
    @SerializedName("asp")
    val asp: String,
    @SerializedName("fr")
    val fr: Int,
    @SerializedName("gen")
    val gen: String,
    @SerializedName("pos")
    val pos: String,
    @SerializedName("text")
    val text: String
)