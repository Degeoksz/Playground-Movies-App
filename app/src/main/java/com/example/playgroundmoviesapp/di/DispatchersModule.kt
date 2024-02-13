package com.example.playgroundmoviesapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

const val DISPATCHERS_IO = "DISPATCHERS_IO"
const val DISPATCHERS_DEFAULT = "DISPATCHERS_DEFAULT"
const val DISPATCHERS_MAIN = "DISPATCHERS_MAIN"

@Module
@InstallIn(ViewModelComponent::class)
object DispatchersModule {
    @Named(DISPATCHERS_IO)
    @Provides
    fun provideDispatchersIo(): CoroutineDispatcher = Dispatchers.IO

    @Named(DISPATCHERS_DEFAULT)
    @Provides
    fun provideDispatchersDefault(): CoroutineDispatcher = Dispatchers.Default

    @Named(DISPATCHERS_MAIN)
    @Provides
    fun provideDispatchersMain(): CoroutineDispatcher = Dispatchers.Main
}
