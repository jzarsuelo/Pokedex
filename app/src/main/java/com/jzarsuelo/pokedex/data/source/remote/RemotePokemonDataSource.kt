package com.jzarsuelo.pokedex.data.source.remote

import com.jzarsuelo.pokedex.data.Pokemon
import com.jzarsuelo.pokedex.data.PokemonDetails
import com.jzarsuelo.pokedex.data.source.PokemonDataSource
import com.jzarsuelo.pokedex.network.PokemonApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withTimeout
import javax.inject.Inject

class RemotePokemonDataSource @Inject constructor(
    private val pokemonApiService: PokemonApiService
) : PokemonDataSource {
    override fun loadPokemon(): Flow<List<Pokemon>> = flow {
        val data = withTimeout(10_000) {
            pokemonApiService.getPokemonInKantoRegion().results
                .sortedBy { it.id }
        }
        emit(data)
    }

    override fun getPokemonDetails(pokemonId: Int): Flow<PokemonDetails>  = flow {
        val data = withTimeout(10_000) {
            pokemonApiService.getPokemonDetails(pokemonId)
        }
        emit(data)
    }
}