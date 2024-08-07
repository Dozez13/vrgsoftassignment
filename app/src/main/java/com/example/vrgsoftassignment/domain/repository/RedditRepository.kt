package com.example.vrgsoftassignment.domain.repository

import com.example.vrgsoftassignment.domain.entity.RedditPostQueryMap
import com.example.vrgsoftassignment.domain.entity.RedditResponse
import feign.QueryMap
import feign.RequestLine

interface RedditRepository {
    @RequestLine("GET /top.json")
    suspend fun getTopRedditPosts(@QueryMap redditPostQueryMap: RedditPostQueryMap): RedditResponse
}
