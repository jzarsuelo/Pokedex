package com.jzarsuelo.pokedex.data.source

import com.jzarsuelo.pokedex.data.Pokemon
import com.jzarsuelo.pokedex.data.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun loadPokemon(): Flow<List<Pokemon>>

    fun getPokemonDetails(pokemonId: Int): Flow<PokemonDetails>
}