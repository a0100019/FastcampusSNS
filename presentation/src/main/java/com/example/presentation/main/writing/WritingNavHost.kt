package com.example.presentation.main.writing

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.theme.ConnectedTheme

@Composable
fun WritingNavHost() {

    val navController = rememberNavController()
    val sharedViewModel:WritingViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = WritingRoute.IMAGE_SELECT_SCREEN.route,
    ) {

        composable(
            route = WritingRoute.IMAGE_SELECT_SCREEN.route
        ) {
            ImageSelectScreen(viewModel = sharedViewModel)
        }

        composable(
            route = WritingRoute.WRITING_SCREEN.route
        ) {

        }

    }
}
