package com.jzarsuelo.pokedex.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.jzarsuelo.pokedex.data.PokemonDetails
import com.jzarsuelo.pokedex.data.source.PokemonRepository
import com.jzarsuelo.pokedex.ui.BaseViewModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

class PokemonDetailViewModel @ViewModelInject constructor(
    private val pokemonRepository: PokemonRepository
) : BaseViewModel() {

    private val pokemonIdChannel = ConflatedBroadcastChannel<Int>()

    val pokemonDetailsLiveData: LiveData<PokemonDetails> = pokemonIdChannel.asFlow()
        .flatMapLatest { pokemonId -> pokemonRepository.getPokemonDetails(pokemonId) }
        .onStart { _isWorkOnGoing.value = true }
        .onEach { _isWorkOnGoing.value = false }
        .catch { t ->
            _isWorkOnGoing.value = false
            _errorMessage.value = t.message
        }
        .asLiveData()

    fun loadPokemonDetails(pokemonId: Int) {
        pokemonIdChannel.offer(pokemonId)
    }
}