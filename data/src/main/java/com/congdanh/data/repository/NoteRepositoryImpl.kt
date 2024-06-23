package com.congdanh.data.repository

import com.congdanh.common.dispatcher.CoroutineDispatchers
import com.congdanh.data.source.local.dao.NoteDao
import com.congdanh.data.source.local.entities.NoteEntity
import com.congdanh.data.source.local.entities.asDomain
import com.congdanh.data.source.local.entities.asEntity
import com.congdanh.domain.model.Note
import com.congdanh.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
    private val dispatchers: CoroutineDispatchers,
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> =
        noteDao.getAll().map { it.map(NoteEntity::asDomain) }.flowOn(dispatchers.io)

    override suspend fun insert(note: Note) {
        withContext(dispatchers.io) {
            noteDao.insert(note.asEntity())
        }
    }

    override suspend fun update(note: Note) {
        withContext(dispatchers.io) {
            noteDao.update(note.asEntity())
        }
    }

    override suspend fun delete(note: Note) {
        withContext(dispatchers.io) {
            noteDao.delete(note.asEntity())
        }
    }

}
