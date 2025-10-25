package com.isaac.klist.data

import androidx.room.*

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List)

    @Update
    suspend fun update(list: List)

    @Delete
    suspend fun delete(list: List)

    @Query("SELECT * FROM list")
    suspend fun getAllLists(): kotlin.collections.List<List>
}