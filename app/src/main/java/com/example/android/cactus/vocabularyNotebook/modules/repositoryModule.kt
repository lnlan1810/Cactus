package com.example.android.cactus.vocabularyNotebook.modules

import com.example.android.cactus.vocabularyNotebook.repository.CategoryRepository
import com.example.android.cactus.vocabularyNotebook.repository.WordsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CategoryRepository(dao = get()) }
    single { WordsRepository(dao = get()) }
}