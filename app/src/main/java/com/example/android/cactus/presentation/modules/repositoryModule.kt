package com.example.android.cactus.presentation.modules

import com.example.android.cactus.domain.repository.CategoryRepository
import com.example.android.cactus.domain.repository.WordsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CategoryRepository(dao = get()) }
    single { WordsRepository(dao = get()) }
}