package com.jzarsuelo.pokedex.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import com.jzarsuelo.pokedex.data.Pokemon
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonItemViewHolder(view: View, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(view) {
    fun bind(pokemon: Pokemon) {
        itemView.apply {
            name_text_view.text = pokemon.formattedName
            id_text_view.text = pokemon.formattedId

            pokemon_image_view.load(pokemon.imageSource, imageLoader)
        }
    }
}