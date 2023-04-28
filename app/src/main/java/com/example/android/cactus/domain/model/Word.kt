package com.example.android.cactus.domain.model

import android.os.Parcelable
import com.example.android.cactus.data.database.entities.WordDb
import kotlinx.android.parcel.Parcelize

@Parcelize
class Word(
    val id: Long,
    var name: String,
    var translation: String,
    var goodWord: Int,
    var categoryId: Long,
) : Parcelable

fun Word.toDatabaseModel(): WordDb {
    return WordDb(
        id = id,
        name = name,
        translation = translation,
        goodWord = goodWord,
        categoryId = categoryId
    )
}
