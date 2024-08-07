package com.example.vrgsoftassignment.core.config

import androidx.paging.PagingSource
import com.example.vrgsoftassignment.core.paging.RedditPagingSource
import com.example.vrgsoftassignment.core.service.RedditService
import com.example.vrgsoftassignment.core.service.impl.RedditServiceImpl
import com.example.vrgsoftassignment.domain.entity.RedditPostResponse
import com.example.vrgsoftassignment.domain.repository.RedditRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {


    @Provides
    @Singleton
    fun provideRedditService(redditRepository: RedditRepository): RedditService =
        RedditServiceImpl(redditRepository)

    @Provides
    @Singleton
    fun providePagingSource(redditService: RedditService): PagingSource<String, RedditPostResponse> =
        RedditPagingSource(redditService)
}