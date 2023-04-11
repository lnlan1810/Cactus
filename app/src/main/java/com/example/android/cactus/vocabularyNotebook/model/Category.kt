package com.example.android.cactus.vocabularyNotebook.model

import android.os.Parcelable
import com.example.android.cactus.database.entities.CategoryDb
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Long,
    var name: String
) : Parcelable

fun Category.toDatabaseModel(): CategoryDb {
    return CategoryDb(
        id = id,
        name = name
    )
}
