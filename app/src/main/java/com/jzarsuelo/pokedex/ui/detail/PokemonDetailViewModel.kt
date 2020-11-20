package com.jzarsuelo.pokedex.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.jzarsuelo.pokedex.data.PokemonDetails
import com.jzarsuelo.pokedex.data.source.PokemonRepository
import com.jzarsuelo.pokedex.ui.BaseViewModel
import com.jzarsuelo.pokedex.util.Message.ErrorMessage
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

class PokemonDetailViewModel @ViewModelInject constructor(
    private val pokemonRepository: PokemonRepository
) : BaseViewModel() {

    private val pokemonIdChannel = ConflatedBroadcastChannel<Int>()

    val pokemonDetailsLiveData: LiveData<PokemonDetails> = pokemonIdChannel.asFlow()
        .flatMapLatest { pokemonId ->
            pokemonRepository.getPokemonDetails(pokemonId)
                    .catch { t -> showError(ErrorMessage(t.message!!)) }
        }
        .onStart {
            clearError()
            _isWorkOnGoing.value = true
        }
        .onEach {
            _isWorkOnGoing.value = false
        }
        .catch { t -> showError(ErrorMessage(t.message!!)) }
        .asLiveData()

    fun loadPokemonDetails(pokemonId: Int) {
        pokemonIdChannel.offer(pokemonId)
    }
}