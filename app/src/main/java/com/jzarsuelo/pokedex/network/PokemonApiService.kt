package com.jzarsuelo.pokedex.network

import com.jzarsuelo.pokedex.data.PokemonDetails
import com.jzarsuelo.pokedex.network.response.PokemonCollectionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemonInKantoRegion(): PokemonCollectionResponse

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonDetails(@Path("pokemonId") pokemonId: Int): PokemonDetails
}