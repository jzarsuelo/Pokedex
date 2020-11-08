package com.jzarsuelo.pokedex.data.source.di

import com.jzarsuelo.pokedex.data.source.PokemonDataSource
import com.jzarsuelo.pokedex.data.source.remote.RemotePokemonDataSource
import com.jzarsuelo.pokedex.di.scope.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    @RemoteDataSource
    abstract fun bindWeatherRepository(remotePokemonDataSource: RemotePokemonDataSource): PokemonDataSource
}