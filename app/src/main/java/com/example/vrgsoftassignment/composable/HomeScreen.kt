package com.example.vrgsoftassignment.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vrgsoftassignment.core.viewmodel.RedditViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    redditViewModel: RedditViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = { HomeAppBar(title = "Reddit Client") },
        content = { innerPadding ->
            RedditPosts(
                redditViewModel.getRedditTopPosts(),
                Modifier.padding(innerPadding)
            )
        }
    )
}