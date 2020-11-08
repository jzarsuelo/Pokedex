package com.jzarsuelo.pokedex.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.ImageLoader
import com.jzarsuelo.pokedex.R
import com.jzarsuelo.pokedex.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private lateinit var adapter: PokemonCollectionAdapter
    private val viewModel: HomeViewModel by viewModels()

    @Inject lateinit var imageLoader: ImageLoader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadPokemon()

        swipe_to_refresh.setOnRefreshListener { onSwipeToRefresh() }
        pokemon_recyler_view.layoutManager = LinearLayoutManager(this.context)

        adapter = PokemonCollectionAdapter(imageLoader) { pokemonId ->
            val action = HomeFragmentDirections.actionHomeFragmentToPokemonDetailFragment(pokemonId)
            findNavController().navigate(action)
        }
        pokemon_recyler_view.adapter = adapter

        viewModel.apply {
            pokemonListLiveData.observe(viewLifecycleOwner, Observer { pokemonList ->
                adapter.refreshData(pokemonList)
            })
            isWorkOnGoing.observe(viewLifecycleOwner, Observer { isWorkOnGoing ->
                swipe_to_refresh.isRefreshing = isWorkOnGoing
            })
            errorMessage.observe(viewLifecycleOwner, Observer {
                showMessage(it, getString(R.string.refresh)) { viewModel.loadPokemon() }
            })
        }

    }

    private fun onSwipeToRefresh() {
        viewModel.loadPokemon()
    }
}