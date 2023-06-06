package com.example.android.cactus.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName("asp")
    val asp: String,
    @SerializedName("fr")
    val fr: Int,
    @SerializedName("gen")
    val gen: String,
    @SerializedName("mean")
    val mean: List<Meaning>,
    @SerializedName("pos")
    val pos: String,
    @SerializedName("syn")
    val syn: List<Synonym>,
    @SerializedName("text")
    val text: String
)