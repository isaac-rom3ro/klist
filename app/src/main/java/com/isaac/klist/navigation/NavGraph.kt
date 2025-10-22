package com.isaac.klist.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.isaac.klist.ui.HomeScreen
import com.isaac.klist.ui.NewList

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable ("home") { HomeScreen(navController) }
        composable ("newList") { NewList() }
    }
}