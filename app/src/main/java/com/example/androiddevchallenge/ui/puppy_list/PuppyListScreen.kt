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
package com.example.androiddevchallenge.ui.puppy_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.util.LocalNavigator

@Composable
fun PuppyListScreen() {
    val viewModel = viewModel<PuppyListViewModel>()
    val puppies by viewModel.puppies.collectAsState()
    val navigator = LocalNavigator.current

    Scaffold(
        topBar = { PuppyListTopBar() }
    ) {
        LazyColumn {
            items(puppies) { puppy ->
                PuppyRow(
                    puppy = puppy,
                    onClickPuppy = { navigator.navigateDetail(it.id) }
                )
                Divider(modifier = Modifier.height(1.dp))
            }
        }
    }
}

@Composable
fun PuppyListTopBar() {
    TopAppBar(
        title = { Text("Compose Puppies") }
    )
}

@Composable
fun PuppyRow(puppy: Puppy, onClickPuppy: (Puppy) -> Unit) {
    Row(
        modifier = Modifier
            .clickable { onClickPuppy(puppy) }
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Text(text = puppy.icon, style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = puppy.name, style = MaterialTheme.typography.h5)
    }
}

@Preview("Light Theme", widthDp = 360)
@Composable
fun LightPuppyRow() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyRow(
                puppy = Puppy(1, "🐶", "Lucy", "7 Years 3 month", "Female"),
                onClickPuppy = {}
            )
        }
    }
}

@Preview("Dark Theme", widthDp = 360)
@Composable
fun DarkPuppyRow() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            PuppyRow(
                puppy = Puppy(1, "🐶", "Lucy", "7 Years 3 month", "Female"),
                onClickPuppy = {}
            )
        }
    }
}
