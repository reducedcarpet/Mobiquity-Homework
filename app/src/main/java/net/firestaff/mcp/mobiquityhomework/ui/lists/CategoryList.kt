package net.firestaff.mcp.mobiquityhomework.ui.lists

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import net.firestaff.mcp.mobiquityhomework.models.Category

@Composable
fun CategoryList(items: List<Category>, navController: NavController) {

    LazyColumn() {
        items(items) { item ->
            ProductList(item, navController)
        }
    }
}
