package com.example.vrgsoftassignment.composable

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.vrgsoftassignment.R
import com.example.vrgsoftassignment.core.dateOfPosting
import com.example.vrgsoftassignment.domain.entity.RedditPostDataResponse

@Composable
fun RedditPost(redditPostDataResponse: RedditPostDataResponse) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(redditPostDataResponse.url)) }
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(redditPostDataResponse.thumbnail)
                        .crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(20.dp)
                        .clip(CircleShape)
                        .clickable { context.startActivity(intent) }
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
            ) {
                Column {
                    Text(
                        text = redditPostDataResponse.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(text = redditPostDataResponse.author)
                    Text(text = dateOfPosting(redditPostDataResponse.created))
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)

            ) {
                Text(text = "${redditPostDataResponse.num_comments} comments")
            }

        }
    }


}