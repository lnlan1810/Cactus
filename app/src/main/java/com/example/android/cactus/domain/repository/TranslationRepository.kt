package com.example.android.cactus.domain.repository

import com.example.android.cactus.domain.common.Resource
import com.example.android.cactus.domain.model.entity.Translation
import kotlinx.coroutines.flow.Flow

interface TranslationRepository {
    fun getTranslation(word: String): Flow<Resource<Translation>>
}