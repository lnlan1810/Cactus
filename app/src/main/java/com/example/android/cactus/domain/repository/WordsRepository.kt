package com.example.android.cactus.domain.repository

import androidx.lifecycle.LiveData
import com.example.android.cactus.data.database.dao.WordDao
import com.example.android.cactus.data.database.entities.toDomainModel
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.domain.model.toDatabaseModel

class WordsRepository(private val dao: WordDao) {

    val totalWords: LiveData<Int> = dao.getTotalOfWords()

    fun addWord(word: Word) =
        dao.addWord(word.toDatabaseModel())

    fun updateWord(word: Word) =
        dao.updateWord(word.toDatabaseModel())

    fun deleteWord(word: Word) =
        dao.deleteWord(word.toDatabaseModel())

    fun deleteWordsOfCategory(id: Long) =
        dao.deleteWordsOfCategory(id)

    fun getWordsOfCategory(categoryId: Long): List<Word> =
        dao.getWordsOfCategory(categoryId).toDomainModel()

}