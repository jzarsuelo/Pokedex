package com.jzarsuelo.pokedex.network.response

import com.jzarsuelo.pokedex.data.Pokemon

data class PokemonCollectionResponse (
    val results: List<Pokemon>
)