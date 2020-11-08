package com.jzarsuelo.pokedex.network

import com.jzarsuelo.pokedex.network.response.PokemonCollectionResponse
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemonInKantoRegion(): PokemonCollectionResponse
}