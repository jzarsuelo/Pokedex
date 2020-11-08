package com.jzarsuelo.pokedex.data

import com.jzarsuelo.pokedex.network.di.NetworkModule

data class Pokemon (
    val name: String,
    val url: String
) {
    val id: Int by lazy {
        url.replace(NetworkModule.BASE_URL, "")
            .split("/")[1]
            .toInt()
    }
    val formattedId: String by lazy { "#" + id.toString().padStart(3, '0') }
    val formattedName: String by lazy { name.capitalize() }
    val imageSource: String by lazy { "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${id}.svg" }
}