package com.congdanh.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.congdanh.domain.model.Note

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val timestamp: Long,
)

fun NoteEntity.asDomain() = Note(
    id = id,
    title = title,
    description = description,
    timestamp = timestamp,
)

fun Note.asEntity() = NoteEntity(
    id = id,
    title = title,
    description = description,
    timestamp = timestamp,
)
