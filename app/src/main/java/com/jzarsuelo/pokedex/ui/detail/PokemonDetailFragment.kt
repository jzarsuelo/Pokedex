package com.jzarsuelo.pokedex.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.load
import com.jzarsuelo.pokedex.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*
import kotlinx.android.synthetic.main.item_pokemon.*
import javax.inject.Inject

@AndroidEntryPoint
class PokemonDetailFragment : Fragment() {

    private val viewModel: PokemonDetailViewModel by viewModels()
    private val args: PokemonDetailFragmentArgs by navArgs()

    @Inject lateinit var imageLoader: ImageLoader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            loadPokemonDetails(args.pokemonId)
            pokemonDetailsLiveData.observe(viewLifecycleOwner, Observer { pokemonDetails ->
                name_text_view.text = pokemonDetails.formattedName
                id_text_view.text = pokemonDetails.formattedId
                pokemon_image_view.load(pokemonDetails.imageSource, imageLoader)
            })
            isWorkOnGoing.observe(viewLifecycleOwner, Observer { isWorkOnGoing ->
                swipe_to_refresh.isRefreshing = isWorkOnGoing
            })
        }
    }
}