package com.example.android.cactus.presentation.modules

import com.example.android.cactus.presentation.viewmodel.AddWordViewModel
import com.example.android.cactus.presentation.viewmodel.CategoryViewModel
import com.example.android.cactus.presentation.viewmodel.LearnViewModel
import com.example.android.cactus.presentation.viewmodel.WordsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { CategoryViewModel(repoCategory = get(), repoWords = get(), dispatchers = get()) }
    viewModel { WordsViewModel(repoWord = get(), repoCategory = get(), dispatchers = get()) }
    viewModel { AddWordViewModel(repository = get(), dispatchers = get()) }
    viewModel { LearnViewModel(repository = get(), dispatchers = get()) }
}