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
package com.example.androiddevchallenge.data.repository

import com.example.androiddevchallenge.data.model.Puppy

class PuppyRepository {

    fun getPuppies(): List<Puppy> {
        return puppies
    }

    fun getPuppy(id: Int): Puppy {
        return puppies.first { it.id == id }
    }

    companion object {
        private val puppies = listOf(
            Puppy(1, "🐶", "Lucy", "7 Years 3 month", "Female"),
            Puppy(2, "🐕", "Bella", "4 Years 8 month", "Female"),
            Puppy(3, "🐕‍🦺", "Lola", "6 Years 11 month", "Male"),
            Puppy(4, "🦮", "Duke", "7 Years 1 month", "Male"),
            Puppy(5, "🐩", "Oliver", "3 Years 2 month", "Male"),
            Puppy(6, "🐶", "Lily", "5 Years 7 month", "Female"),
            Puppy(7, "🐕", "Loki", "3 Years 4 month", "Male"),
            Puppy(8, "🐕‍🦺", "Coco", "7 Years 3 month", "Female"),
            Puppy(9, "🦮", "Max", "4 Years 7 month", "Male"),
            Puppy(10, "🐩", "Mia", "5 Years 1 month", "Female"),
            Puppy(11, "🐶", "Roxy", "4 Years 2 month", "Male"),
            Puppy(12, "🐕", "Remi", "6 Years 5 month", "Female"),
            Puppy(13, "🐕‍🦺", "Lucky", "5 Years 10 month", "Male"),
            Puppy(14, "🦮", "Leo", "6 Years 4 month", "Male"),
            Puppy(15, "🐩", "Rocky", "4 Years 4 month", "Male"),
        )
    }
}
