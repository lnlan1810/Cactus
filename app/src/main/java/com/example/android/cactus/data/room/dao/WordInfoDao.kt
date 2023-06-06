package com.example.android.cactus.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.cactus.domain.model.entity.WordInfo

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfo>)

    @Query("DELETE FROM wordinfo WHERE term IN(:words)")
    suspend fun deleteWordInfos(words: List<String>)

    @Query("SELECT * FROM wordinfo WHERE term LIKE '%' || :word || '%'")
    suspend fun getWordInfos(word: String): List<WordInfo>
}