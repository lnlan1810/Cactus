package com.example.android.cactus.domain.utils

sealed class UiEvent {
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}

