package com.jzarsuelo.pokedex.network.response

import com.jzarsuelo.pokedex.data.Stat
import com.squareup.moshi.Json

data class RawStat(
    @Json(name =  "base_stat") val baseStat: Int,
    val stat: StatName
) {
    fun toStat(): Stat = Stat(name = stat.name, value = baseStat)
}

data class StatName(
    val name: String
)

data class RawPokemonType(
    val slot: Int,
    val type: PokemonTypeName
)

data class PokemonTypeName(
    val name: String
)

data class PokemonDescription(
    @Json(name = "flavor_text") val description: String
)