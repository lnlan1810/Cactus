package com.example.android.cactus.data.remote

import com.example.android.cactus.data.remote.dto.TranslationDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DictionaryAPI {

    @GET("/api/v1/dicservice.json/lookup")
    suspend fun getSuggestTranslation(
        @Query("key") key: String,
        @Query("lang") lang: String,
        @Query("text") text: String,
    ) : TranslationDto
}
