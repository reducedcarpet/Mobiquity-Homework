package net.firestaff.mcp.mobiquityhomework.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import net.firestaff.mcp.mobiquityhomework.models.Category
import net.firestaff.mcp.mobiquityhomework.ui.TopAppBarScaffold
import net.firestaff.mcp.mobiquityhomework.ui.lists.CategoryList

@Composable
fun MainScreen(
    navController: NavController,
    categories: List<Category>
) {
    TopAppBarScaffold(
        title = "Snack List",
        navController = navController,
        content = {
            MainScreenContent(navController, categories)
        }
    )
}

@Composable
fun MainScreenContent(
    navController: NavController,
    categories: List<Category>
) {
    CategoryList(
        categories,
        navController
    )
}