package com.example.android.cactus.data.remote.dto

data class Translation(
    val fr: Int,
    val mean: List<Mean>,
    val pos: String,
    val syn: List<Syn>,
    val text: String
)