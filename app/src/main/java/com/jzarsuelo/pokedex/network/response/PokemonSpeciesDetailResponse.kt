package com.jzarsuelo.pokedex.network.response

import com.squareup.moshi.Json

data class PokemonSpeciesDetailResponse(
    @Json(name =  "base_happiness") val baseHappiness: Int,
    @Json(name =  "capture_rate") val captureRate: Int,
    @Json(name =  "flavor_text_entries") val descriptions: List<PokemonDescription>
) {
    val description: String = descriptions[0].description
}