package com.jzarsuelo.pokedex.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
    protected val _errorMessage: MutableLiveData<String> = MutableLiveData()

    /**
     * This field is the exposed field for View layer to observe for any error encountered by the ViewModel
     */
    val errorMessage: LiveData<String> = _errorMessage
}