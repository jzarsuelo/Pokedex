package com.jzarsuelo.pokedex.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.jzarsuelo.pokedex.data.Pokemon
import com.jzarsuelo.pokedex.data.source.PokemonRepository
import com.jzarsuelo.pokedex.di.scope.IoDispactcher
import com.jzarsuelo.pokedex.ui.BaseViewModel
import com.jzarsuelo.pokedex.util.Message.ErrorMessage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

class HomeViewModel @ViewModelInject constructor(
    private val pokemonRepository: PokemonRepository,
    @IoDispactcher private val ioDispactcher: CoroutineDispatcher
) : BaseViewModel() {

    private val pokemonListChannel = ConflatedBroadcastChannel<Long>()

    val pokemonListLiveData: LiveData<List<Pokemon>> = pokemonListChannel.asFlow()
        .flatMapLatest {
            clearError()
            pokemonRepository.loadPokemon().catch { t ->
                showError(ErrorMessage(t.message!!))
                emit(listOf())
            }
        }
        .flowOn(ioDispactcher)
        .onStart {
            _isWorkOnGoing.value = true
        }
        .onEach {
            _isWorkOnGoing.value = false
        }
        .catch { t ->
            showError(ErrorMessage(t.message!!))
            emit(listOf())
        }
        .asLiveData()


    fun loadPokemon() {
        pokemonListChannel.offer(System.currentTimeMillis())
    }

}