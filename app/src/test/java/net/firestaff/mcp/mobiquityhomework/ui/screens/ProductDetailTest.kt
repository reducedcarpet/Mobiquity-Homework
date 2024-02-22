package net.firestaff.mcp.mobiquityhomework.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import net.firestaff.mcp.mobiquityhomework.models.Product
import net.firestaff.mcp.mobiquityhomework.models.SalePrice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(instrumentedPackages = ["androidx.loader.content"],sdk = [32])
@RunWith(RobolectricTestRunner::class)
class ProductDetailContentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun productDetailContent_displaysProductNameAndDescription() {
        // Example product data
        val product = Product(
            id = "15",
            categoryId = "151",
            name = "Test Product",
            description = "Test Description",
            url = "",
            salePrice = SalePrice(amount = "10.00", currency = "USD")
        )

        composeTestRule.setContent {
            ProductDetailContent(product = product)
        }

        // Check that the product name and description are displayed
        composeTestRule.onNodeWithText("Name: Test Product").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description: Test Description").assertIsDisplayed()
        composeTestRule.onNodeWithText("Price: 10.00 USD").assertIsDisplayed()
    }
}