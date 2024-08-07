package com.example.vrgsoftassignment.domain.entity

data class RedditDataResponse(
    val children: List<RedditPostResponse>,
    val after: String?,
    val before: String?
)
