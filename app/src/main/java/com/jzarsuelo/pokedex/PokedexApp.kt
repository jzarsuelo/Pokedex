package com.jzarsuelo.pokedex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.DebugTree
import timber.log.Timber.plant

@HiltAndroidApp
class PokedexApp : Application() {
    override fun onCreate() {
        super.onCreate()
        BuildConfig.DEBUG.takeIf { it }?.let { plant(DebugTree()) }
    }
}