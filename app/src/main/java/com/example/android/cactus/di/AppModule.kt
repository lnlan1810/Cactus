package com.example.android.cactus.di

import com.example.android.cactus.data.remote.DictionaryAPI
import com.example.android.cactus.data.respository.TranslationRepositoryImpl
import com.example.android.cactus.domain.common.Constants
import com.example.android.cactus.domain.repository.TranslationRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideYandexTranslateApi(): DictionaryAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.YANDEX_TRANSLATE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideTranslationRepository(api: DictionaryAPI): TranslationRepository {
        return TranslationRepositoryImpl(api)
    }
}