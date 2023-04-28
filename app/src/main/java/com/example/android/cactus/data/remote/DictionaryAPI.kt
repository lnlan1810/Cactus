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

/*
    @GET("/api/v1/dicservice.json/lookup?key=dict.1.1.20230419T155150Z.0c6d953e3dde7e0a.6d184698b812548bb09217e1937892cbf4cce290&lang=ru-en&text={word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<TranslationDto>

 */
}