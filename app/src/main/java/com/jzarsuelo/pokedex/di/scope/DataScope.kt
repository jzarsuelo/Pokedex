package com.jzarsuelo.pokedex.di.scope

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class LocalDataSource

@Qualifier
@Retention(RUNTIME)
annotation class RemoteDataSource