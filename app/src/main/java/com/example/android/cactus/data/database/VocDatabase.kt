package com.example.android.cactus.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.cactus.data.database.dao.CategoryDao
import com.example.android.cactus.data.database.dao.WordDao
import com.example.android.cactus.data.database.entities.CategoryDb
import com.example.android.cactus.data.database.entities.WordDb

@Database(
    entities = [WordDb::class, CategoryDb::class],
    version = 1,
    exportSchema = false
)

abstract class VocDatabase : RoomDatabase() {

    abstract val categoryDao : CategoryDao
    abstract val wordDao : WordDao

    companion object {
        private lateinit var INSTANCE: VocDatabase

        fun getDatabase(context: Context): VocDatabase {
            synchronized(VocDatabase::class.java) {
                if (!Companion::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        VocDatabase::class.java, "VocDatabase"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}