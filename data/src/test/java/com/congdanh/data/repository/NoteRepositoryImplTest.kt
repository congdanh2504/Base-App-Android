package com.congdanh.data.repository

import com.congdanh.common.dispatcher.CoroutineDispatchers
import com.congdanh.data.source.local.dao.NoteDao
import com.congdanh.data.source.local.entities.NoteEntity
import com.congdanh.data.source.local.entities.asDomain
import com.congdanh.data.source.local.entities.asEntity
import com.congdanh.domain.model.Note
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class NoteRepositoryImplTest {

    @Mock
    private lateinit var noteDao: NoteDao

    @Mock
    private lateinit var dispatchers: CoroutineDispatchers
    private lateinit var noteRepository: NoteRepositoryImpl
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        `when`(dispatchers.io).thenReturn(testDispatcher)
        `when`(dispatchers.main).thenReturn(testDispatcher)
        noteRepository = NoteRepositoryImpl(noteDao, dispatchers)
    }

    @Test
    fun testGetNotes() = runTest {
        val noteEntities = listOf(NoteEntity(1, "Title", "Content", 0L))
        val notes = noteEntities.map { it.asDomain() }

        `when`(noteDao.getAll()).thenReturn(flowOf(noteEntities))

        val result = noteRepository.getNotes().first()

        assertEquals(notes, result)
        verify(noteDao).getAll()
    }

    @Test
    fun testInsertNote() = runTest {
        val note = Note(1, "Title", "Content", 0L)
        val noteEntity = note.asEntity()

        noteRepository.insert(note)

        verify(noteDao).insert(noteEntity)
    }

    @Test
    fun testUpdateNote() = runTest {
        val note = Note(1, "Title", "Content", 0L)
        val noteEntity = note.asEntity()

        noteRepository.update(note)

        verify(noteDao).update(noteEntity)
    }

    @Test
    fun testDeleteNote() = runTest {
        val note = Note(1, "Title", "Content", 0L)
        val noteEntity = note.asEntity()

        noteRepository.delete(note)

        verify(noteDao).delete(noteEntity)
    }
}
