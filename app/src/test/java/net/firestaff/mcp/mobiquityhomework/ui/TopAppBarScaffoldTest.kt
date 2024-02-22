package net.firestaff.mcp.mobiquityhomework.ui

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@Config(instrumentedPackages = ["androidx.loader.content"],sdk = [32])
@RunWith(RobolectricTestRunner::class)
class TopAppBarScaffoldTest {

    @Before
    fun setUp() {
        val originalThreadPolicy = StrictMode.getThreadPolicy()
        StrictMode.setThreadPolicy(
            ThreadPolicy.Builder(originalThreadPolicy).permitDiskReads().permitDiskWrites().build()
        )

    }

    @After
    fun tearDown() {
        StrictMode.setThreadPolicy(StrictMode.getThreadPolicy())
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun topAppBarScaffold_displaysTitleCorrectly() {
        composeTestRule.setContent {
            val navController = rememberNavController() // Create a NavController
            TopAppBarScaffold(
                title = "Test Title",
                navController = navController,
                content = {}
            )
        }

        // Check that the title is displayed in the TopAppBar
        composeTestRule
            .onNodeWithText("Test Title")
            .assertIsDisplayed()
    }
}
