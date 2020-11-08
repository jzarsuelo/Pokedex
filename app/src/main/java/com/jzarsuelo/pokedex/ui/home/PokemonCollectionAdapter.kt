package com.jzarsuelo.pokedex.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import com.jzarsuelo.pokedex.R
import com.jzarsuelo.pokedex.data.Pokemon

class PokemonCollectionAdapter(
    private val imageLoader: ImageLoader,
    private val pokemonCollection: MutableList<Pokemon> = mutableListOf()
) : RecyclerView.Adapter<PokemonItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonItemViewHolder {
        return PokemonItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false), imageLoader)
    }

    override fun getItemCount(): Int = pokemonCollection.size

    override fun onBindViewHolder(holder: PokemonItemViewHolder, position: Int) {
        holder.bind(pokemonCollection[position])
    }

    fun refreshData(pokemonCollection: List<Pokemon>) {
        this.pokemonCollection.clear()
        this.pokemonCollection.addAll(pokemonCollection)
        notifyDataSetChanged()
    }

}