package com.jzarsuelo.pokedex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jzarsuelo.pokedex.util.Message

abstract class BaseViewModel : ViewModel() {
    /**
     * Field to update whenever a [ViewModel] is working on somthing in the background
     */
    protected val _isWorkOnGoing: MutableLiveData<Boolean> = MutableLiveData(false)

    /**
     * This field is the exposed field for View layer to observe if the work is already done
     */
    val isWorkOnGoing: LiveData<Boolean> = _isWorkOnGoing

    /**
     * Field to update whenever a [ViewModel] encountered an error
     */
    protected val _errorMessage: MutableLiveData<Message> = MutableLiveData()

    /**
     * This field is the exposed field for View layer to observe for any error encountered by the ViewModel
     */
    val errorMessage: LiveData<Message> = _errorMessage

    protected fun showError(message: Message) {
        _errorMessage.postValue(message)
        _isWorkOnGoing.postValue(false)
    }

    protected fun clearError() {
        _errorMessage.postValue(Message.None())
        _isWorkOnGoing.postValue(true)
    }
}