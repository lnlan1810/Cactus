package com.example.android.cactus.domain.use_case

import com.example.android.cactus.domain.common.Resource
import com.example.android.cactus.domain.model.entity.Translation
import com.example.android.cactus.domain.repository.TranslationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTranslationUseCase @Inject constructor(
    private val repository: TranslationRepository,
) {
    operator fun invoke(word: String): Flow<Resource<Translation>> {
        if(word.isBlank()) {
            return flow {  }
        }
        return repository.getTranslation(word)
    }
}