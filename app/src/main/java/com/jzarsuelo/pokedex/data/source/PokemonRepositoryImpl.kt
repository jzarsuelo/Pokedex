package com.jzarsuelo.pokedex.data.source

import com.jzarsuelo.pokedex.data.Pokemon
import com.jzarsuelo.pokedex.di.scope.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    @RemoteDataSource val remotePokemonDataSource: PokemonDataSource
) : PokemonRepository {
    override fun loadPokemon(): Flow<List<Pokemon>> = remotePokemonDataSource.loadPokemon()
}