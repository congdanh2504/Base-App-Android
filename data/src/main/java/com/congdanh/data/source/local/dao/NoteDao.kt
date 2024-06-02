package com.congdanh.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.congdanh.data.source.local.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM NoteEntity")
    fun getAll(): Flow<List<NoteEntity>>

    @Insert
    suspend fun insert(note: NoteEntity)

    @Delete
    suspend fun deleteById(note: NoteEntity)

    @Update
    suspend fun update(note: NoteEntity)
}
