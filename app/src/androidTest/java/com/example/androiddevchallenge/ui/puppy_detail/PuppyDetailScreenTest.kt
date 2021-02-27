package com.example.androiddevchallenge.ui.puppy_detail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androiddevchallenge.MainActivity
import com.example.androiddevchallenge.data.puppies
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PuppyDetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val puppy = puppies.first()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MyTheme {
                PuppyDetailScreen(id = puppy.id, navigateBack = {})
            }
        }

        // for Debugging
        composeTestRule.onRoot().printToLog(TAG)
    }

    @Test
    fun showPuppyDetailScreen() {
        composeTestRule.onNodeWithText("Compose Puppies").assertIsDisplayed()

        composeTestRule.onNodeWithText(puppy.name, substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(puppy.age, substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithText(puppy.gender, substring = true).assertIsDisplayed()

        // button
        composeTestRule.onNodeWithText("Adopt", substring = true).assertIsDisplayed()
    }

    companion object {
        private const val TAG = "PuppyDetailScreenTest"
    }
}