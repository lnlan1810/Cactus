package com.example.android.cactus.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.cactus.data.room.dao.WordInfoDao
import com.example.android.cactus.domain.model.entity.WordInfo

@Database(
    entities = [WordInfo::class],
    version = 1,
    exportSchema = true
)
@TypeConverters()
abstract class Database: RoomDatabase() {
    abstract val dao: WordInfoDao
}