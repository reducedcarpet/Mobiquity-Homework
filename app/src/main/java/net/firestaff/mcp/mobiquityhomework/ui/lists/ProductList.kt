package net.firestaff.mcp.mobiquityhomework.ui.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import net.firestaff.mcp.mobiquityhomework.models.Category
import net.firestaff.mcp.mobiquityhomework.ui.ListTile
import net.firestaff.mcp.mobiquityhomework.ui.ProductImage
import java.net.URLEncoder

@Composable
fun ProductList(item: Category, navController: NavController) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Category: " + item.name,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        item.products.forEach { product ->
            ListTile(
                title = product.name,
                trailing = { Text(product.salePrice.amount + " " + product.salePrice.currency) },
                onClick = {
                    val gson = Gson()
                    val productJson = gson.toJson(product)
                    navController.navigate(
                        "productDetail/${URLEncoder.encode(productJson, "UTF-8")}"
                    )
                },
                leading = { ProductImage(url = product.url, productName = product.name) }
            )
        }
    }
}