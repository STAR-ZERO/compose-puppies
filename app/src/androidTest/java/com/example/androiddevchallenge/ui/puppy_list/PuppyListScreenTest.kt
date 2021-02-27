package com.example.androiddevchallenge.ui.puppy_list

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.navigation.compose.rememberNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androiddevchallenge.MainActivity
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PuppyListScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            MyTheme {
                PuppyListScreen(navController)
            }
        }

        // for Debugging
        composeTestRule.onRoot().printToLog(TAG)
    }

    @Test
    fun showPuppyListScreen() {
        composeTestRule.onNodeWithText("Compose Puppies").assertIsDisplayed()
        composeTestRule.onNodeWithText("Lucy", substring = true).assertIsDisplayed()
    }

    companion object {
        private const val TAG = "PuppyListScreenTest"
    }
}