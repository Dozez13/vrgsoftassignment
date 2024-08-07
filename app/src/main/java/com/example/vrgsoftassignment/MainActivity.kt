package com.example.vrgsoftassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vrgsoftassignment.composable.HomeScreen
import com.example.vrgsoftassignment.ui.theme.VrgsoftassignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listOf(1, 2, 3, 4).map { "test" }
        enableEdgeToEdge()
        setContent {
            VrgsoftassignmentTheme {
                HomeScreen()
            }
        }
    }
}


