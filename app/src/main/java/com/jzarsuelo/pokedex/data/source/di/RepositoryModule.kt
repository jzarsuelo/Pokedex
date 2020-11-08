package com.jzarsuelo.pokedex.data.source.di

import com.jzarsuelo.pokedex.data.source.PokemonRepository
import com.jzarsuelo.pokedex.data.source.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindWeatherRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}