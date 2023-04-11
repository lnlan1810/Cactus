package com.example.android.cactus.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.cactus.vocabularyNotebook.model.Category


@Entity(tableName = "categories")
data class CategoryDb constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String
)

fun List<CategoryDb>.toDomainModel(): List<Category> {
    return map {
        Category(
            id = it.id,
            name = it.name
        )
    }
}
