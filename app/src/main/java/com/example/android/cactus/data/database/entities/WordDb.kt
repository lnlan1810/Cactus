package com.example.android.cactus.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.cactus.domain.model.Word


@Entity(tableName = "words")
data class WordDb constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    var translation: String,
    var goodWord: Int,
    var categoryId: Long,
)

fun List<WordDb>.toDomainModel(): List<Word> {
    return map {
        Word(
            id = it.id,
            name = it.name,
            translation = it.translation,
            goodWord = it.goodWord,
            categoryId = it.categoryId
        )
    }
}

