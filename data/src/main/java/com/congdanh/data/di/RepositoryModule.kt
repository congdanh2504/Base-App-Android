package com.congdanh.data.di

import com.congdanh.data.repository.NoteRepositoryImpl
import com.congdanh.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindNoteRepository(impl: NoteRepositoryImpl): NoteRepository
}
