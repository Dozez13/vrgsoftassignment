package com.example.vrgsoftassignment.domain.entity

data class RedditPostDataResponse(
    val author: String,
    val title: String,
    val num_comments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
)
