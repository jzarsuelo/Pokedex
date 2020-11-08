package com.jzarsuelo.pokedex.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.jzarsuelo.pokedex.data.Pokemon
import com.jzarsuelo.pokedex.data.source.PokemonRepository
import com.jzarsuelo.pokedex.ui.BaseViewModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

class HomeViewModel @ViewModelInject constructor(
    private val pokemonRepository: PokemonRepository
) : BaseViewModel() {

    private val pokemonListChannel = ConflatedBroadcastChannel<Boolean>()

    val pokemonListLiveData: LiveData<List<Pokemon>> = pokemonListChannel.asFlow()
        .flatMapLatest {
            pokemonRepository.loadPokemon()
        }
        .onStart { _isWorkOnGoing.value = true }
        .onEach { _isWorkOnGoing.value = false }
        .catch { t ->
            _isWorkOnGoing.value = false
            _errorMessage.value = t.message
        }
        .asLiveData()


    fun loadPokemon() {
        pokemonListChannel.offer(true)
    }

}