package com.congdanh.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.congdanh.data.source.local.dao.NoteDao
import com.congdanh.data.source.local.entities.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}
