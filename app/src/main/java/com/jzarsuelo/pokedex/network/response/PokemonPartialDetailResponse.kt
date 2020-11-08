package com.jzarsuelo.pokedex.network.response

import com.jzarsuelo.pokedex.data.Stat

data class PokemonPartialDetailResponse(
    val height: Float,
    val id: Int,
    val name: String,
    val weight: Float,
    val stats: List<RawStat>,
    val types: List<RawPokemonType>
) {
    fun getStatsFromRawStats(): List<Stat> = stats.map { it.toStat() }
}