package com.example.vrgsoftassignment.domain.config

import com.example.vrgsoftassignment.domain.repository.RedditRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.kotlin.CoroutineFeign
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeignModule {

    @Provides
    fun provideBaseUrl(): String = "https://www.reddit.com"

    @Provides
    @Singleton
    fun provideGsonEncoder(): GsonEncoder = GsonEncoder()

    @Provides
    @Singleton
    fun provideGsonDecoder(): GsonDecoder = GsonDecoder()


    @Provides
    @Singleton
    fun provideRedditRepository(
        baseUrl: String,
        gsonEncoder: GsonEncoder,
        gsonDecoder: GsonDecoder
    ): RedditRepository =
        CoroutineFeign.builder<Unit>()
            .encoder(gsonEncoder)
            .decoder(gsonDecoder)
            .target(RedditRepository::class.java, baseUrl)

}