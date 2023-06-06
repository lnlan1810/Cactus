package com.example.android.cactus.domain.model.entity

data class WordTranslationState(
    val translation: Translation?,
    val isLoading: Boolean = false
)