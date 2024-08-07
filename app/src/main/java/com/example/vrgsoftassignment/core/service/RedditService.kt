package com.example.vrgsoftassignment.core.service

import com.example.vrgsoftassignment.domain.entity.RedditPostQueryMap
import com.example.vrgsoftassignment.domain.entity.RedditResponse


interface RedditService {
    suspend fun getTopRedditPosts(redditPostQueryMap: RedditPostQueryMap): RedditResponse
}