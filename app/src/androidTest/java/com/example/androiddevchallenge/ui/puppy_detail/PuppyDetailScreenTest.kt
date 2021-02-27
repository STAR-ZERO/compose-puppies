/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
