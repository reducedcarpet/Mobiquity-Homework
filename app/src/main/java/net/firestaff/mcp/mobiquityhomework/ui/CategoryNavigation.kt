package net.firestaff.mcp.mobiquityhomework.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.firestaff.mcp.mobiquityhomework.ui.screens.MainScreen
import net.firestaff.mcp.mobiquityhomework.ui.screens.ProductDetail
import net.firestaff.mcp.mobiquityhomework.viewmodels.CategoryViewModel

@Composable
fun CategoryNavigation(navController: NavHostController, viewModel: CategoryViewModel) {
    val categories by viewModel.categories.observeAsState(initial = emptyList())

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainScreen(navController, categories) }
        composable("productDetail/{productJson}") { backStackEntry ->
            val productJson = backStackEntry.arguments?.getString("productJson") ?: ""
            ProductDetail(navController, productJson)
        }
        // Add more destinations here
    }
}