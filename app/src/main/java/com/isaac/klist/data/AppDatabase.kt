package com.isaac.klist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [List::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun listDao(): ListDao
}