package com.congdanh.common.di

import com.congdanh.common.dispatcher.AppCoroutineDispatchers
import com.congdanh.common.dispatcher.CoroutineDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Singleton
    @Provides
    fun provideCoroutineDispatchers(): CoroutineDispatchers = AppCoroutineDispatchers()
}
