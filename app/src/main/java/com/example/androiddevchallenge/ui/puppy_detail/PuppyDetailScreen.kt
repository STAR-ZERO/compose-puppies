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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyDetailScreen(id: Int, navController: NavController) {
    val viewModelFactory = PuppyDetailViewModel.Factory(id)
    val viewModel = viewModel(PuppyDetailViewModel::class.java, factory = viewModelFactory)

    val puppy by viewModel.puppy.collectAsState()

    Scaffold(
        topBar = { PuppyDetailTopBar(onClickBack = { navController.popBackStack() }) }
    ) {
        PuppyDetailContent(puppy)
    }
}

@Composable
fun PuppyDetailTopBar(onClickBack: () -> Unit) {
    TopAppBar(
        title = { Text("Compose Puppies") },
        navigationIcon = {
            IconButton(onClick = { onClickBack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        },
    )
}

@Composable
fun PuppyDetailContent(puppy: Puppy) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row {
            Text(text = puppy.icon, style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = puppy.name, style = MaterialTheme.typography.h3)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            Text(text = "Age: ", style = MaterialTheme.typography.h6)
            Text(text = puppy.age, style = MaterialTheme.typography.body1)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            Text(text = "Gender: ", style = MaterialTheme.typography.h6)
            Text(text = puppy.gender, style = MaterialTheme.typography.body1)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { }) {
            Icon(Icons.Filled.Star, contentDescription = "Adopt")
            Text(text = "Adopt", style = MaterialTheme.typography.subtitle1)
        }
    }
}

@Preview("Dark Theme", widthDp = 360)
@Composable
fun LightPuppyDetailContent() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PuppyDetailContent(
                puppy = Puppy(1, "🐶", "Lucy", "7 Years 3 month", "Female")
            )
        }
    }
}

@Preview("Dark Theme", widthDp = 360)
@Composable
fun DarkPuppyRow() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            PuppyDetailContent(
                puppy = Puppy(1, "🐶", "Lucy", "7 Years 3 month", "Female")
            )
        }
    }
}
