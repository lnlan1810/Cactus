package com.example.android.cactus.presentation.translate

sealed class WordTranslateEvent {
    data class OnTermChange(val term: String): WordTranslateEvent()
    data class OnDefinitionChange(val definition: String): WordTranslateEvent()
    object OnCloseMenu: WordTranslateEvent()
    object OnMenuClick: WordTranslateEvent()
    object OnShowTranslationDialog: WordTranslateEvent()
    object OnHideTranslationDialog: WordTranslateEvent()
}
