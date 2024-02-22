package net.firestaff.mcp.mobiquityhomework.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import net.firestaff.mcp.mobiquityhomework.models.Category
import net.firestaff.mcp.mobiquityhomework.models.Product
import net.firestaff.mcp.mobiquityhomework.models.SalePrice
import net.firestaff.mcp.mobiquityhomework.ui.lists.CategoryList
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(instrumentedPackages = ["androidx.loader.content"],sdk = [32])
@RunWith(RobolectricTestRunner::class)
class MainScreenContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mainScreenContent_displaysProductNameAndPrice() {
        // Example product data
        val product1 = Product(
            id = "15",
            categoryId = "151",
            name = "Test Product 1",
            description = "Test Description 1",
            url = "",
            salePrice = SalePrice(amount = "10.00", currency = "USD")
        )

        val product2 = Product(
            id = "25",
            categoryId = "152",
            name = "Test Product 2",
            description = "Test Description 2",
            url = "",
            salePrice = SalePrice(amount = "15.00", currency = "USD")
        )

        val category = Category(
            id = "36802",
            name = "Food",
            description = "",
            products = listOf(product1, product2)
        )

        val categories = listOf(category)

        composeTestRule.setContent {
            val navController = rememberNavController()
            CategoryList(categories, navController)
        }

        composeTestRule.onNodeWithText("Category: Food").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test Product 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("10.00 USD").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test Product 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("15.00 USD").assertIsDisplayed()
    }
}