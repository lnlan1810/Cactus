package com.example.android.cactus.vocabularyNotebook.utils

import kotlinx.coroutines.CoroutineDispatcher

// for testing we sometimes need to pass a special couroutine test dispatcher,
// if it would be hardcoded in the viewmodel we've no option to do that

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}