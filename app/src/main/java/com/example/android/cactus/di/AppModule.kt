package com.example.android.cactus.di

import android.app.Application
import androidx.room.Room
import com.example.android.cactus.data.remote.DictionaryAPI
import com.example.android.cactus.data.respository.TranslationRepositoryImpl
import com.example.android.cactus.data.room.Database
import com.example.android.cactus.data.room.dao.WordInfoDao
import com.example.android.cactus.domain.common.Constants
import com.example.android.cactus.domain.repository.TranslationRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): Database {
        val executor = Executors.newSingleThreadExecutor()
        return Room.databaseBuilder(
            app, Database::class.java, "word_db"
        ).setQueryCallback({ sqlQuery, bindArgs ->
            println("SQL Query: $sqlQuery SQL Args: $bindArgs")
        }, Executors.newSingleThreadExecutor()).build()
    }

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