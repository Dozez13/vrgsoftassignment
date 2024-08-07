package com.example.vrgsoftassignment.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.vrgsoftassignment.core.viewmodel.RedditViewModel
import com.example.vrgsoftassignment.domain.entity.RedditPostResponse
import kotlinx.coroutines.flow.Flow

@Composable
fun RedditPosts(
    redditViewModel: RedditViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val lazyRedditPostsItems = redditViewModel.redditResponse.collectAsLazyPagingItems()
    LazyColumn(
        modifier = modifier,
        content = {
            items(lazyRedditPostsItems.itemCount) { index ->
                lazyRedditPostsItems[index]?.let {
                    RedditPost(it.data)
                }
            }
        }
    )
}