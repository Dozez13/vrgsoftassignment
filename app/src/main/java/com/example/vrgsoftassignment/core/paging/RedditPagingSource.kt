package com.example.vrgsoftassignment.core.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.vrgsoftassignment.core.service.RedditService
import com.example.vrgsoftassignment.domain.entity.RedditPostQueryMap
import com.example.vrgsoftassignment.domain.entity.RedditPostResponse
import java.io.IOException

class RedditPagingSource(private val redditService: RedditService) :
    PagingSource<String, RedditPostResponse>() {
    override fun getRefreshKey(state: PagingState<String, RedditPostResponse>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPostResponse> {
        return try {
            val redditPostQueryMap = RedditPostQueryMap(params.key, params.loadSize)
            val response = redditService.getTopRedditPosts(redditPostQueryMap)
            LoadResult.Page(
                data = response.data.children,
                prevKey = null,
                nextKey = response.data.after
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}