package com.jzarsuelo.pokedex.di

import com.jzarsuelo.pokedex.di.scope.DefaultDispatcher
import com.jzarsuelo.pokedex.di.scope.IoDispactcher
import com.jzarsuelo.pokedex.di.scope.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    @IoDispactcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Singleton
    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}