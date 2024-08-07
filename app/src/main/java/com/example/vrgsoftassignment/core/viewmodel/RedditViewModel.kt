package com.example.vrgsoftassignment.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.example.vrgsoftassignment.domain.entity.RedditPostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class RedditViewModel @Inject constructor(private val redditPagingSource: PagingSource<String, RedditPostResponse>) :
    ViewModel() {

    fun getRedditTopPosts(): Flow<PagingData<RedditPostResponse>> {
        return Pager(PagingConfig(10)) { redditPagingSource }.flow
    }
}