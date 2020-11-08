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
        val data = withTimeout(15_000) {
            val partialDetailResponse = pokemonApiService.getPokemonDetails(pokemonId)
            val speciesDetailResponse = pokemonApiService.getSpeciesDetails(pokemonId)

            PokemonDetails(
                height = partialDetailResponse.height,
                id = partialDetailResponse.id,
                name = partialDetailResponse.name,
                weight = partialDetailResponse.weight,
                types = partialDetailResponse.types.map { pokemonType -> pokemonType.type.name },
                stats = partialDetailResponse.getStatsFromRawStats(),
                description = speciesDetailResponse.description,
                baseHappiness = speciesDetailResponse.baseHappiness,
                captureRate = speciesDetailResponse.captureRate
            )
        }
        emit(data)
    }
}