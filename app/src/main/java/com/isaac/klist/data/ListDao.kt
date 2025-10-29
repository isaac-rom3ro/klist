package com.isaac.klist.data

import androidx.room.*

@Dao
interface ListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(listEntity: ListEntity)

    @Update
    suspend fun update(listEntity: ListEntity)

    @Delete
    suspend fun delete(listEntity: ListEntity)

    @Query("SELECT * FROM list")
    suspend fun getAllLists(): kotlin.collections.List<ListEntity>
}