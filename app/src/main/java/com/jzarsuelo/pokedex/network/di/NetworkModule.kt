package com.jzarsuelo.pokedex.network.di

import com.jzarsuelo.pokedex.network.PokemonApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            // TODO Add custom adapter here
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    fun provideClient(): OkHttpClient =
        OkHttpClient.Builder()
            // TODO Remove logging
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    @Provides
    fun buildRetrofit(client: OkHttpClient, factory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(factory)
            .build()
    }

    @Provides
    fun providePokemonApiService(retrofit: Retrofit): PokemonApiService = retrofit.create(PokemonApiService::class.java)
}