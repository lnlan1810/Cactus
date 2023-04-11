package com.example.android.cactus.vocabularyNotebook.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.cactus.database.dao.CategoryDao
import com.example.android.cactus.database.entities.CategoryDb
import com.example.android.cactus.database.entities.toDomainModel
import com.example.android.cactus.vocabularyNotebook.model.Category
import com.example.android.cactus.vocabularyNotebook.model.toDatabaseModel

class CategoryRepository(private val dao: CategoryDao) {

    val categories: LiveData<List<Category>> = Transformations.map(dao.getAllCategories()) {
        it.toDomainModel()
    }

    suspend fun getCategories(): LiveData<List<CategoryDb>> =
        dao.getAllCategories()

    fun addCategory(category: CategoryDb) =
        dao.addCategory(category)

    fun updateCategory(category: Category) =
        dao.updateCategory(category.toDatabaseModel())

    fun deleteCategory(category: Category) =
        dao.deleteCategory(category.toDatabaseModel())

    fun searchDatabase(searchQuery: String): LiveData<List<CategoryDb>> =
        dao.searchDatabase(searchQuery)
}