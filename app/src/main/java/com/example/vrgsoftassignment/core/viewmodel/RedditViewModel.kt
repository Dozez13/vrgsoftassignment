package com.example.vrgsoftassignment.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.example.vrgsoftassignment.domain.entity.RedditPostResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RedditViewModel @Inject constructor(private val redditPagingSource: PagingSource<String, RedditPostResponse>) :
    ViewModel() {

    private val _redditResponse: MutableStateFlow<PagingData<RedditPostResponse>> =
        MutableStateFlow(PagingData.empty())
    var redditResponse = _redditResponse.asStateFlow()
        private set

    init {
        viewModelScope.launch {
            Pager(
                config = PagingConfig(
                    10, enablePlaceholders = true
                )
            ) {
                redditPagingSource
            }.flow.cachedIn(viewModelScope).collect {
                _redditResponse.value = it
            }
        }
    }
}