package com.jzarsuelo.pokedex.network

import com.jzarsuelo.pokedex.network.response.PokemonCollectionResponse
import com.jzarsuelo.pokedex.network.response.PokemonPartialDetailResponse
import com.jzarsuelo.pokedex.network.response.PokemonSpeciesDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemonInKantoRegion(): PokemonCollectionResponse

    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonDetails(@Path("pokemonId") pokemonId: Int): PokemonPartialDetailResponse

    @GET("pokemon-species/{pokemonId}")
    suspend fun getSpeciesDetails(@Path("pokemonId") pokemonId: Int): PokemonSpeciesDetailResponse
}