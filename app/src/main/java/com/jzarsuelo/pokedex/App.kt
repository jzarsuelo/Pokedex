package com.jzarsuelo.pokedex

import android.app.Application
import timber.log.Timber.DebugTree
import timber.log.Timber.plant

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        BuildConfig.DEBUG.takeIf { it }?.let { plant(DebugTree()) }
    }
}