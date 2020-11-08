package com.jzarsuelo.pokedex.data

data class PokemonDetails(
    val height: Float,
    val id: Int,
    val name: String,
    val weight: Float,
    val types: List<String>,
    val stats: List<Stat>,
    val description: String,
    val baseHappiness: Int,
    val captureRate: Int
) {
    val formattedId: String by lazy { "#" + id.toString().padStart(3, '0') }
    val formattedName: String by lazy { name.capitalize() }
    val imageSource: String by lazy { "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${id}.svg" }
}