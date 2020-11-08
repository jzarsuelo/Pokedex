package com.jzarsuelo.pokedex.di.scope

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoDispactcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultDispatcher