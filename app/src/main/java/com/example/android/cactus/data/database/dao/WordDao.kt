package com.example.android.cactus.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.cactus.data.database.entities.WordDb
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert
    fun addWord(word: WordDb)

    @Update
    fun updateWord(word: WordDb)

    @Delete
    fun deleteWord(word: WordDb)

    @Query("DELETE FROM words WHERE categoryId=:categoryId")
    fun deleteWordsOfCategory(categoryId: Long)

    @Query("SELECT * FROM words WHERE categoryId=:categoryId ORDER BY id DESC")
    fun getWordsOfCategory(categoryId: Long): List<WordDb>

    @Query("SELECT COUNT(*) FROM words")
    fun getTotalOfWords(): LiveData<Int>

}
