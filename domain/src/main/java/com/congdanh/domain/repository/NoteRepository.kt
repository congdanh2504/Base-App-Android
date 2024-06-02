package com.congdanh.domain.repository

import com.congdanh.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun insert(note: Note)
    suspend fun update(note: Note)
    suspend fun delete(note: Note)
}
