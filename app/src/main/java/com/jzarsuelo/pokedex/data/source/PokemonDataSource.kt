package com.jzarsuelo.pokedex.data.source

import com.jzarsuelo.pokedex.data.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonDataSource {
    fun loadPokemon(): Flow<List<Pokemon>>
}