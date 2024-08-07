package com.example.vrgsoftassignment.core.service.impl

import com.example.vrgsoftassignment.core.service.RedditService
import com.example.vrgsoftassignment.domain.entity.RedditPostQueryMap
import com.example.vrgsoftassignment.domain.entity.RedditResponse
import com.example.vrgsoftassignment.domain.repository.RedditRepository

class RedditServiceImpl(private val redditRepository: RedditRepository) :
    RedditService {
    override suspend fun getTopRedditPosts(redditPostQueryMap: RedditPostQueryMap): RedditResponse {
        return redditRepository.getTopRedditPosts(redditPostQueryMap);
    }
}