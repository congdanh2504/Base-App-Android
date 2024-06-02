package com.congdanh.data.di

import android.content.Context
import androidx.room.Room
import com.congdanh.data.source.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideNoteDao(appDatabase: AppDatabase) = appDatabase.noteDao()
}
